package kojimation.com.cleanarchitecturemvvmdatabinding.binding;

import android.databinding.Observable;
import android.databinding.ObservableField;

/**
 * Created by muukojima on 2016/11/24.
 */

public abstract class OnFieldChangedCallback<T> extends ObservableField.OnPropertyChangedCallback {
    @Override
    public void onPropertyChanged(Observable sender, int propertyId) {
        onChanged(((ObservableField<T>)sender).get());
    }

    protected abstract void onChanged(T field);
}

