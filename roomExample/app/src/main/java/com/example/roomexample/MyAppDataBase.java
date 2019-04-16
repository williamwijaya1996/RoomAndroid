package com.example.roomexample;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class MyAppDataBase extends RoomDatabase {

    public abstract MyDao myDao();
}
