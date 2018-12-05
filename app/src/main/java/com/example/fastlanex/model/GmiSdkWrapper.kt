package com.example.fastlanex.model

interface GmiSdkWrapper {

    /**
     * Wrapper around access to the GMI SDK, providing it as an external data source interface
     * @param userId user ID
     * @return User object
     */
    fun getUser(userId: String): User
}
