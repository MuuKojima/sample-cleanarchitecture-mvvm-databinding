package kojimation.com.cleanarchitecturemvvmdatabinding.di;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.repository.ExchangeRepositoryModule;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.PostExecutionThread;

/**
 * Created by muukojima on 2016/11/24.
 */

@Module(includes = {ExchangeRepositoryModule.class})
public class RepositoryModule {

    @Provides
    @Singleton
    public PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    public Executor provideExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }
}
