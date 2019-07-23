package techy.ap.sample.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import techy.ap.sample.data.model.User;

@Dao
public interface UserDao {

//    void getAllusers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... users);

    @Delete
    void delete(User... users);

    @Update
    void update(User... users);

}
