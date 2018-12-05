package com.example.fastlanex.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    fun save(user: User)

    @Query("SELECT * FROM user WHERE uniqueNumericId = :uniqueNumericId")
    fun load(uniqueNumericId: Int): LiveData<User>

    @Query("SELECT * FROM user WHERE email = :userId")
    fun load(userId: String): LiveData<User>

}
