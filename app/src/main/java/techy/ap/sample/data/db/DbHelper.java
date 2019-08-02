package techy.ap.sample.data.db;


import java.util.List;

import io.reactivex.Observable;
import techy.ap.sample.data.model.User;

public interface DbHelper {

    Observable<Boolean> insertUser_ACTION(User users);

    Observable<Boolean> insertUser(User users);

    Observable<List<User>> getAllusers();

}
