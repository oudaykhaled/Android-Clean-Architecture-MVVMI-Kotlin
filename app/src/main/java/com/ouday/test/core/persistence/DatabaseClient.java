package com.ouday.test.core.persistence;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private static DatabaseClient mInstance;
    private static Context context;
    private AppDatabase appDatabase;

    private DatabaseClient(Context mCtx) {
        this.context = mCtx;
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "db.db").build();
    }

    public static void init(Context context){
        DatabaseClient.context = context;
    }

    public static synchronized DatabaseClient getInstance() {
        if (mInstance == null) {
            mInstance = new DatabaseClient(context);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
