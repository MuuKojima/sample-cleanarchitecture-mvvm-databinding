package kojimation.com.cleanarchitecturemvvmdatabinding.di;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Component;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.ExchangeRateRepository;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.PostExecutionThread;
import kojimation.com.cleanarchitecturemvvmdatabinding.di.ApiModule;

/**
 * Created by muukojima on 2016/11/24.
 */

@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {


    ExchangeRateRepository exchangeRateRepository();

    Executor executor();

    PostExecutionThread postExecutionThread();
}