package techy.ap.sample.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import techy.ap.sample.di.module.main.MainModule;
import techy.ap.sample.di.module.main.VMM_Main;
import techy.ap.sample.mvvm.view.MainActivity;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(

            modules = {
                    MainModule.class,
                    VMM_Main.class
            }
    )
    abstract MainActivity contributeMainActivity();

}
