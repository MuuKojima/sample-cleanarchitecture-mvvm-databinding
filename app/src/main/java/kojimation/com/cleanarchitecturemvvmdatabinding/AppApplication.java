package kojimation.com.cleanarchitecturemvvmdatabinding;

import android.app.Application;

import kojimation.com.cleanarchitecturemvvmdatabinding.di.AppComponent;
import kojimation.com.cleanarchitecturemvvmdatabinding.di.DaggerAppComponent;

/**
 * Created by muukojima on 2016/11/24.
 */

public class AppApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}