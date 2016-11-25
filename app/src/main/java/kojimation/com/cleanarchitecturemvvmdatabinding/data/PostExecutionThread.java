package kojimation.com.cleanarchitecturemvvmdatabinding.data;


import rx.Scheduler;

/**
 * Created by muukojima on 2016/11/22.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
