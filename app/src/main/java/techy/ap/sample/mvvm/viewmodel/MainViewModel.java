package techy.ap.sample.mvvm.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.room.RoomDatabase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import techy.ap.sample.Base.BaseViewModel;
import techy.ap.sample.data.db.DBClient;
import techy.ap.sample.data.db.DbHelper;
import techy.ap.sample.data.model.User;
import techy.ap.sample.mvvm.presenter.MainNavigator;


public class MainViewModel extends BaseViewModel<MainNavigator> {

    private static final String TAG = "MainViewModel";

    @Inject
    Context context;

    @Inject
    DbHelper dbHelper;

    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> phone = new MutableLiveData<>();
    public MutableLiveData<String> address = new MutableLiveData<>();

    @Inject
    public MainViewModel() {
    }

    public void getClassName() {
        getNavigator().getContext(context);
    }


    @SuppressLint({"StaticFieldLeak", "CheckResult"})
    public void registerUser() {

        User user = new User();
        user.setName(name.getValue());
        user.setPhone(phone.getValue());
        user.setAddress(address.getValue());


        Observable<Boolean> insertUser = dbHelper.insertUser(user);

        insertUser
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(aBoolean -> {
                    Log.d(TAG, "registerUser: " + aBoolean );
                });

        Observable<List<User>> allusers = dbHelper.getAllusers();
        allusers.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                      users -> Log.d(TAG, "list :" + users)
                );

//        Bitmap bitmap = BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length);
    }

}
