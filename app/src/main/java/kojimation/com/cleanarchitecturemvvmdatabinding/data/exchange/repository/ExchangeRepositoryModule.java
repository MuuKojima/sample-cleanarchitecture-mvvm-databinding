package kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.ExchangeRateRepository;
import retrofit2.Retrofit;

/**
 * Created by muukojima on 2016/11/22.
 */

@Module
public class ExchangeRepositoryModule {
    @Singleton
    @Provides
    public ExchangeRateRepository provideExchangeRateRepository(ExchangeRateRepositoryImpl exchangeRateRepository) {
        return exchangeRateRepository;
    }

    @Provides
    @Singleton
    public ExchangeRateApi provideExchangeRateApi(Retrofit retrofit) {
        return retrofit.create(ExchangeRateApi.class);
    }
}