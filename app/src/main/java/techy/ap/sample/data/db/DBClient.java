package techy.ap.sample.data.db;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import techy.ap.sample.data.model.User;

@Singleton
public class DBClient implements DbHelper{

    private static final String TAG = "DBClient";

    private AppDatabase appDatabase;
    Disposable disposable;


    @Inject
    public DBClient(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }


    @Override
    public Observable<Boolean> insertUser_ACTION(User users) {
         Completable.fromAction(() ->
                 appDatabase.userDao().insert(users))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                         disposable = d;
                    }

                    @Override
                    public void onComplete() {

                        Log.d(TAG, "onComplete: success");
                        
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d(TAG, "onError: " + e.getMessage());

                    }
                });




        return null;
    }

    @Override
    public Observable<Boolean> insertUser(User users) {
        return Observable.fromCallable(() -> {
            appDatabase.userDao().insert(users);
            return true;
        });
    }

    @Override
    public Observable<List<User>> getAllusers() {
        return Observable.fromCallable(() -> appDatabase.userDao().getAllusers());

    }
}
