package kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.repository;

import javax.inject.Inject;
import javax.inject.Singleton;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.ExchangeRateResponse;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.ExchangeRateRepository;
import rx.Observable;

/**
 * Created by muukojima on 2016/11/22.
 */

@Singleton
/* package */ class ExchangeRateRepositoryImpl implements ExchangeRateRepository {

    private final ExchangeRateApi mExchangeRateApi;

    @Inject
    public ExchangeRateRepositoryImpl(ExchangeRateApi mExchangeRateApi) {
        this.mExchangeRateApi = mExchangeRateApi;
    }

    @Override
    public Observable<ExchangeRateResponse> getExchangeRate(String base, String symbols) {
        return mExchangeRateApi.getExchangeRate(base, symbols);
    }
}

