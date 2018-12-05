package com.example.fastlanex.testutils

import android.os.Bundle
import androidx.multidex.MultiDex
import androidx.test.runner.AndroidJUnitRunner

class FastlaneTestRunner : AndroidJUnitRunner() {
    override fun onCreate(arguments: Bundle) {
        MultiDex.install(targetContext)
        super.onCreate(arguments)
    }
}
