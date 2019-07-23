package techy.ap.sample.Base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import java.io.Serializable;
import dagger.android.support.DaggerAppCompatActivity;
import techy.ap.sample.Base.utils.CommonUtils;
import techy.ap.sample.Base.utils.NetworkUtils;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends DaggerAppCompatActivity
implements BaseFragment.Callback {

    private static final String TAG = "BaseActivity";
    private ProgressDialog mProgressDialog;
    private T mViewDataBinding;
    private V mViewModel;

    public abstract int getBindingVariable();
    public abstract V getViewModel();

    public abstract
    @LayoutRes
    int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        performDataBinding();

    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    private void performDataBinding() {
        mViewDataBinding =
        DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = (mViewModel == null) ? mViewModel = getViewModel() : mViewModel;
//        mViewDataBinding.setLifecycleOwner(this);
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }



    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    public void setIntent(Class<?> cls) {
        startActivity(new Intent(getApplicationContext(), cls));
    }

    public void setIntent(Class<?> cls, String tag, Object object) {
        Intent intent = new Intent(getApplicationContext(), cls);
        intent.putExtra(tag, (Serializable) object);
        startActivity(intent);
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    public void performDependencyInjection() {
//        AndroidInjection.inject(this);
    }

    public void openActivityOnTokenExpire() {
//        startActivity(LoginActCLivity.newIntent(this));
        finish();
    }




}
