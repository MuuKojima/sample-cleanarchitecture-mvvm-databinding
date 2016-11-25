package kojimation.com.cleanarchitecturemvvmdatabinding.ui.exchange;

import dagger.Component;
import kojimation.com.cleanarchitecturemvvmdatabinding.di.AppComponent;
import kojimation.com.cleanarchitecturemvvmdatabinding.di.PerActivity;

/**
 * Created by muukojima on 2016/11/24.
 */

@PerActivity
@Component(dependencies = {AppComponent.class})
/* package */ interface ExchangeRateComponent {
    void inject(ExchangeRateActivity activity);
}
