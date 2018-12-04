package com.example.fastlanex.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private const val appDatabaseName : String = "database-gvid-user"
        fun database(context: Context) : UserDatabase {
            return Room.databaseBuilder(
                context,
                UserDatabase::class.java, appDatabaseName
            ).build()
        }
    }
}
