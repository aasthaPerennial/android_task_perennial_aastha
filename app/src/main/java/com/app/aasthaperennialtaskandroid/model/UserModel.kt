package com.app.aasthaperennialtaskandroid.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserModel(@ColumnInfo(name = "isUserLogin") val isUserLogin: Boolean,
                     @ColumnInfo(name = "isUserFirstTimeVisit") val isUserFirstTimeVisit: Boolean,
                     @ColumnInfo(name = "firstName") val firstName: String,
                     @ColumnInfo(name = "lastName") val lastName: String,
                     @PrimaryKey
                     @ColumnInfo(name = "email") val email: String,
                     @ColumnInfo(name = "password") val password: String)