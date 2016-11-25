package kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.usecase;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.ExchangeRateRepository;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.exchange.ExchangeRateResponse;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.PostExecutionThread;
import kojimation.com.cleanarchitecturemvvmdatabinding.data.UseCase;
import rx.Observable;

/**
 * Created by muukojima on 2016/11/24.
 */

public class GetExchangeRate extends UseCase<ExchangeRateResponse> {

    private final ExchangeRateRepository mExchangeRateRepository;

    @Inject
    protected GetExchangeRate(Executor threadExecutor, PostExecutionThread postExecutionThread, ExchangeRateRepository exchangeRateRepository) {
        super(threadExecutor, postExecutionThread);
        this.mExchangeRateRepository = exchangeRateRepository;
    }

    public Observable<ExchangeRateResponse> execute(String base, String symbols) {
        return bindUIThread(mExchangeRateRepository.getExchangeRate(base, symbols));
    }
}
