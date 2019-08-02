package techy.ap.sample.data.db;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private static DatabaseClient Instance;
    AppDatabase appDatabase;


    public static DatabaseClient getInstance(Context context)
    {
        if (Instance == null)
        {
            Instance = new DatabaseClient(context);
        }
        return Instance;
    }

    public DatabaseClient(Context context) {

        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "db.sqlite")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

    }

    public AppDatabase getAppDatabse()
    {
        return appDatabase;

    }



}
