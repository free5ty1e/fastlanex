package com.example.fastlanex.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.fastlanex.model.User
import com.example.fastlanex.model.UserRepository

class UserProfileViewModel(private val userRepo : UserRepository) : ViewModel(){
    var userId: String? = null
    var user: LiveData<User>? = null

    fun init(userId: String) {
        this.userId = userId
        user = userRepo.getUser(userId)
    }
}
