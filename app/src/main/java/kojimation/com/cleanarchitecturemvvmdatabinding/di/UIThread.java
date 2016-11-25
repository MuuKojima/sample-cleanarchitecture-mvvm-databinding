package kojimation.com.cleanarchitecturemvvmdatabinding.di;

import javax.inject.Inject;
import javax.inject.Singleton;

import kojimation.com.cleanarchitecturemvvmdatabinding.data.PostExecutionThread;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by muukojima on 2016/11/22.
 */

@Singleton
/* package */ class UIThread implements PostExecutionThread {

    @Inject
    public UIThread() {
    }

    @Override
    public Scheduler getScheduler() {
        // RxのメソッドでMainスレッドを取得
        return AndroidSchedulers.mainThread();
    }
}