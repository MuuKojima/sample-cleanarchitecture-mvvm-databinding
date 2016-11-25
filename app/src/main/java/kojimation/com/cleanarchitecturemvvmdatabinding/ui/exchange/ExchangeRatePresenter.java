package kojimation.com.cleanarchitecturemvvmdatabinding.ui.exchange;

import android.util.Log;

import javax.inject.Inject;

import kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.ExchangeRateResponse;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.usecase.GetExchangeRate;
import kojimation.com.cleanarchitecturemvvmdatabinding.di.PerActivity;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by muukojima on 2016/11/24.
 */

@PerActivity
/* package */ class ExchangeRatePresenter {
    private final CompositeSubscription mSubscriptions = new CompositeSubscription();
    private final GetExchangeRate mGetExchangeRate;
    private ExchangeRateView mView;

    @Inject
    public ExchangeRatePresenter(GetExchangeRate getExchangeRate) {
        this.mGetExchangeRate = getExchangeRate;
    }

    public void getExchangeRate() {
        addSubscription(mGetExchangeRate.execute("USD", "JPY")
                .subscribe(
                        new Observer<ExchangeRateResponse>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d("通信 -> ", "失敗" + e.toString());
                            }

                            @Override
                            public void onNext(ExchangeRateResponse exchangeRateResponse) {
                                mView.bindExchangeRate(exchangeRateResponse);
                            }
                        }
                ));
    }

    public void setView(ExchangeRateView view) {
        mView = view;
    }

    private void addSubscription(Subscription s) {
        mSubscriptions.add(s);
    }

    protected void unsubscribe() {
        mSubscriptions.clear();
    }
}