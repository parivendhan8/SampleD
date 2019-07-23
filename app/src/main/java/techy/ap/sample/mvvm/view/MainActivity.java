package techy.ap.sample.mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import techy.ap.sample.BR;
import techy.ap.sample.Base.BaseActivity;
import techy.ap.sample.R;
import techy.ap.sample.databinding.ActivityMainBinding;
import techy.ap.sample.di.ViewModelProviderFactory;
import techy.ap.sample.mvvm.presenter.MainNavigator;
import techy.ap.sample.mvvm.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator {

    private static final String TAG = "MainActivity";

    ActivityMainBinding binding;

    MainViewModel viewModel;

    @Inject
    ViewModelProviderFactory factory;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }


    @Override
    public MainViewModel getViewModel() {

        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        return viewModel;

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getViewDataBinding();
        viewModel.setNavigator(this);
        viewModel.getClassName();

    }

    @Override
    public void save() {


        viewModel.registerUser();



    }

    @Override
    public void getContext(final Context context) {


        Log.d(TAG, "getContext: " + context.getApplicationContext().getClass());



    }
}
