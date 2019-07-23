package techy.ap.sample.di.module.main;


import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import techy.ap.sample.di.scope.ViewModelKey;
import techy.ap.sample.mvvm.viewmodel.MainViewModel;

@Module
public abstract class VMM_Main {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindsAndroidViewModel(MainViewModel mainViewModel);


}
