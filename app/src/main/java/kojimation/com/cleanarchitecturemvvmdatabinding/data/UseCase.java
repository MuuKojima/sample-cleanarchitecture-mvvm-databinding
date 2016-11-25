package kojimation.com.cleanarchitecturemvvmdatabinding.data;

import java.util.concurrent.Executor;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by muukojima on 2016/11/22.
 */

public abstract class UseCase<T> {
    protected final Executor threadExecutor;
    protected final PostExecutionThread postExecutionThread;

    protected UseCase(Executor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    protected Observable<T> bindUIThread(Observable<T> useCaseeObservable) {
        return useCaseeObservable
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler());
    }
}
