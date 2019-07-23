package techy.ap.sample.mvvm.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import techy.ap.sample.Base.BaseViewModel;
import techy.ap.sample.data.model.User;
import techy.ap.sample.mvvm.presenter.MainNavigator;


public class MainViewModel extends BaseViewModel<MainNavigator> {

    @Inject
    Context context;

    MutableLiveData<String> name = new MutableLiveData<>();
    MutableLiveData<String> phone = new MutableLiveData<>();
    MutableLiveData<String> address = new MutableLiveData<>();

    @Inject
    public MainViewModel() {
    }

    public void getClassName()
    {
        getNavigator().getContext(context);
    }


    public void registerUser()
    {
        User user = new User();
        user.setName(name.getValue());
        user.setPhone(phone.getValue());
        user.setAddress(address.getValue());


    }


//        @Inject
//    public MainViewModel(@NonNull Application application) {
//        super(application);
//    }
}
