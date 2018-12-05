package com.example.fastlanex.screenshot

import android.util.Log
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class ScreenshotTakingRule : TestWatcher() {

    override fun succeeded(description: Description?) {
//        Log.d(javaClass.simpleName, ".succeeded: $description\nSleeping for ${MILLIS_TO_WAIT_FOR_SCREENSHOT}ms to allow pending screenshots to finish before killing activity...")
//        UiThreadStatement.runOnUiThread { Thread.sleep(MILLIS_TO_WAIT_FOR_SCREENSHOT) }
        Log.d(javaClass.simpleName, ".succeeded: $description\nTaking success screenshot...")
        takeSuccessScreenshot(description?.className, description?.methodName!!)
//        super.succeeded(description)
    }

    override fun failed(e: Throwable?, description: Description) {
        Log.d(javaClass.simpleName, ".failed: $description\nTaking failure screenshot...")
        takeFailureScreenshot(description.className, description.methodName)
    }
}

//private const val MILLIS_TO_WAIT_FOR_SCREENSHOT: Long = 1000
