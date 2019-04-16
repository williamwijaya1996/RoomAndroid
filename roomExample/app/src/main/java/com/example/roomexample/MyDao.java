package com.example.roomexample;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addUser(User user);


    @Query("select * from users")
    public List<User> getUsers();

    @Delete
    public void deleteUsers(User user);

    @Update
    public void updateUsers(User user);

    @Query("update users set user_name=:name where id =:id")
    public void updateUserName(String name,int id);

    

}
