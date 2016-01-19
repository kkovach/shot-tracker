package com.squidshoe.golf.shottracker.db;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
//import timber.log.Timber;

/**
 * Created by kkovach on 7/16/15.
 */
@Module
public final class DbModule {

    @Provides
    @Singleton
    SQLiteOpenHelper provideOpenHelper(Application application) {

        return new DbOpenHelper(application);
    }

    @Provides
    @Singleton
    SqlBrite provideSqlBrite() {

        return SqlBrite.create(new SqlBrite.Logger() {

            @Override
            public void log(String message) {

//                Timber.tag("Database").v(message);
            }
        });
    }

    @Provides
    @Singleton
    BriteDatabase provideDatabase(SqlBrite sqlBrite, SQLiteOpenHelper helper) {

        return sqlBrite.wrapDatabaseHelper(helper);
    }
}
