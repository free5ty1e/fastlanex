package com.example.fastlanex.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey var uniqueNumericId: Int,
    @ColumnInfo(name = "email") var email: String?,
    @ColumnInfo(name = "first_name") var firstName: String?,
    @ColumnInfo(name = "last_name") var lastName: String?
) {
    fun getUserId() : String? {
        return email
    }
    fun setUserId(userId : String) {
        email = userId
    }
}
