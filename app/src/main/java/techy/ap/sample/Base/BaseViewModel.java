package techy.ap.sample.Base;

import androidx.lifecycle.ViewModel;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;


public abstract class BaseViewModel<N> extends ViewModel {

    private WeakReference<N> navigator;

    private CompositeDisposable compositeDisposable;

//    public BaseViewModel(@NonNull Application application) {
//        super(application);
//        compositeDisposable = new CompositeDisposable();
//    }

    public BaseViewModel() {

        compositeDisposable = new CompositeDisposable();

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public N getNavigator() {
        return navigator.get();
    }

    public void setNavigator(N navigator) {
        this.navigator = new WeakReference<>(navigator);
    }


}
