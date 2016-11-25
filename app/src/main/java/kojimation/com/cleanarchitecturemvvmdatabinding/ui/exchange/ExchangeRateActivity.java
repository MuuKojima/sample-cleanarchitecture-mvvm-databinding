package kojimation.com.cleanarchitecturemvvmdatabinding.ui.exchange;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import kojimation.com.cleanarchitecturemvvmdatabinding.AppApplication;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.ExchangeRateResponse;
import kojimation.com.cleanarchitecturemvvmdatabinding.binding.OnFieldChangedCallback;
import kojimation.com.cleanarchitecturemvvmdatabinding.R;

public class ExchangeRateActivity extends AppCompatActivity {

    @Inject
    ExchangeRatePresenter mPresenter;
    @Inject
    ExchangeRateViewModel mModel;

    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_rate);

        mTextView = (TextView) findViewById(R.id.txt_jpy);

        DaggerExchangeRateComponent.builder()
                .appComponent(((AppApplication) getApplicationContext()).getAppComponent())
                .build()
                .inject(this);
        // Presenter/ViewModelの設定
        mPresenter.setView(mModel);

        mModel.onExchangeRateChanged(new OnExchangeRateChanged());

        mPresenter.getExchangeRate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }

    private class OnExchangeRateChanged extends OnFieldChangedCallback<ExchangeRateResponse> {
        @Override
        protected void onChanged(ExchangeRateResponse exchangeRateResponse) {
            mTextView.setText("JPY: " + String.valueOf(exchangeRateResponse.getRates().getJPY()));
        }
    }
}
