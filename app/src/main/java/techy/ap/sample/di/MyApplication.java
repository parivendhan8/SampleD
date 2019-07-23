package techy.ap.sample.di;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import techy.ap.sample.di.component.DaggerAppComponent;

public class MyApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {

        return DaggerAppComponent.builder().application(this).build();
    }

    /*


    @PerApplication
    @Component(modules = {AndroidInjectionModule.class, LoginBindingModule.class})
    public interface ApplicationComponent {
        void inject(ExampleApplication application);
    }

    @Module
    public abstract class LoginBindingModule {
        @ContributesAndroidInjector
        abstract LoginActivity contributeYourActivityInjector();
    }

    public class LoginActivity extends Activity {

        @Inject
        LoginPresenter loginPresenter;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            AndroidInjection.inject(this);
            super.onCreate(savedInstanceState);
        }
    }

    public class LoginPresenter {

        @Inject
        public LoginPresenter() {

        }
    }
    */
}
