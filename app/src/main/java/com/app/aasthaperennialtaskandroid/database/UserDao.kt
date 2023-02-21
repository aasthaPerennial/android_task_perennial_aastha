package com.app.aasthaperennialtaskandroid.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.aasthaperennialtaskandroid.model.UserModel

@Dao
interface UserDao{

    @Insert
    fun addUser(user : List<UserModel>)

    @Query("SELECT * FROM user")
    fun getUser() : List<UserModel>
}