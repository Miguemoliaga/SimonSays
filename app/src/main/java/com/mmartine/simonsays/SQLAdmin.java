package com.mmartine.simonsays;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLAdmin extends SQLiteOpenHelper {

    private String sqlCreate = "CREATE TABLE records (score int, name text)";

    public SQLAdmin(@Nullable Context context, @Nullable String name,
                       @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int lastVersion, int newVersion) {


        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS records");

        sqLiteDatabase.execSQL(sqlCreate);
    }
}
