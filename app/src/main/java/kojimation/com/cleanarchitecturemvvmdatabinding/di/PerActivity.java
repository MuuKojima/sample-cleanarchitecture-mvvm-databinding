package kojimation.com.cleanarchitecturemvvmdatabinding.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by muukojima on 2016/11/24.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}
