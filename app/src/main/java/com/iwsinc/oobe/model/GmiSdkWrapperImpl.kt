package com.example.fastlanex.model

class GmiSdkWrapperImpl : GmiSdkWrapper {
    override fun getUser(userId: String): User {

        //TODO: Remove hardcoded test user for framework development:
        return User(0, "example@example.com", "User", "Lastname")

    }
}