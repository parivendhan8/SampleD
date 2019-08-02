package techy.ap.sample.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import techy.ap.sample.data.db.dao.UserDao;
import techy.ap.sample.data.model.User;

@Database(entities = User.class, version = 1, exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}
