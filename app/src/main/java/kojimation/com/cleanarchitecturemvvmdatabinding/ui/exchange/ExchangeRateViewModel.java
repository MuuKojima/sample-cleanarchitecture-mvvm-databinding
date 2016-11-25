package kojimation.com.cleanarchitecturemvvmdatabinding.ui.exchange;

import android.databinding.ObservableField;

import javax.inject.Inject;

import kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.ExchangeRateResponse;
import kojimation.com.cleanarchitecturemvvmdatabinding.binding.OnFieldChangedCallback;
import kojimation.com.cleanarchitecturemvvmdatabinding.di.PerActivity;

/**
 * Created by muukojima on 2016/11/24.
 */

@PerActivity
/* package */ class ExchangeRateViewModel implements ExchangeRateView {

    private final ObservableField<ExchangeRateResponse> mExchangeRateResponse = new ObservableField<>();

    @Inject
    public ExchangeRateViewModel() {
    }

    @Override
    public void bindExchangeRate(ExchangeRateResponse exchangeRateResponse) {
        mExchangeRateResponse.set(exchangeRateResponse);
    }

    // observe

    public void onExchangeRateChanged(OnFieldChangedCallback<ExchangeRateResponse> callback) {
        addCallback(mExchangeRateResponse, callback);
    }

    protected final <T> void addCallback(final ObservableField<T> observable, final OnFieldChangedCallback<T> callback) {
        observable.addOnPropertyChangedCallback(callback);
    }
}
