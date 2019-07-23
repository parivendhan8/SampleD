package techy.ap.sample.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import techy.ap.sample.di.MyApplication;
import techy.ap.sample.di.module.ActivityBuilderModule;
import techy.ap.sample.di.module.AppModule;
import techy.ap.sample.di.module.ViewModelFactoryModule;


@Singleton
@Component(

        modules = {

                AndroidSupportInjectionModule.class,
                ViewModelFactoryModule.class,
                AppModule.class,
                ActivityBuilderModule.class,

                }
)

public interface AppComponent extends AndroidInjector<MyApplication> {


    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
