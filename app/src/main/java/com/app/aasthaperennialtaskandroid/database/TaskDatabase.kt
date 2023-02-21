package com.app.aasthaperennialtaskandroid.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.aasthaperennialtaskandroid.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun getUserDao() : UserDao

    companion object {
        private var INSTANCE: TaskDatabase? = null
        fun getDatabase(context: Context): TaskDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context, TaskDatabase::class.java, "taskDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }

}