package techy.ap.sample.data.db;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DBClient implements DbHelper{

    private final AppDatabase appDatabase;

    @Inject
    public DBClient(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }



}
