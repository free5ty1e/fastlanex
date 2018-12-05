package com.example.fastlanex.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class UserRepository : KoinComponent {
    private val gmiSdkWrapper: GmiSdkWrapper by inject()

    // Simple in-memory cache. Details omitted for brevity.
//    private val userCache: UserCache? = null

    fun getUser(userId: String): LiveData<User> {
        val data = MutableLiveData<User>()
        data.value = gmiSdkWrapper.getUser(userId)
        return data
    }
}
