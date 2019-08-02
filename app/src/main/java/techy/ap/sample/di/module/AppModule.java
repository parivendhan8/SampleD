package techy.ap.sample.di.module;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import techy.ap.sample.constants.Constants;
import techy.ap.sample.data.db.AppDatabase;
import techy.ap.sample.data.db.DBClient;
import techy.ap.sample.data.db.DbHelper;


@Module
public class AppModule {


//    private final  Context context;
//
//    public AppModule(Context context) {
//        this.context = context;
//    }

    @Singleton
    @Provides
    Context provideContext(Application application)
    {
        return application;
    }


    @Singleton
    @Provides
    static AppDatabase providerAppDatabse(Context context){

        return Room.databaseBuilder(context, AppDatabase.class, "test")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

    }

    @Singleton
    @Provides
    static DbHelper provideDbHelper(AppDatabase appDatabase)
    {
        return new DBClient(appDatabase);
    }


    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance()
    {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



}
