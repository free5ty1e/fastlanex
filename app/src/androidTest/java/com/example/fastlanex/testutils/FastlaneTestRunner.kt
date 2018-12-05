package com.example.fastlanex.testutils

import android.os.Bundle
import android.support.multidex.MultiDex
import android.support.test.runner.AndroidJUnitRunner

class FastlaneTestRunner : AndroidJUnitRunner() {
    override fun onCreate(arguments: Bundle) {
        MultiDex.install(targetContext)
        MultiDex.installInstrumentation(context, targetContext)
        super.onCreate(arguments)
    }
}
