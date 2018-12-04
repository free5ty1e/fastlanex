package com.example.fastlanex.screenshot

import android.util.Log
import androidx.test.runner.screenshot.Screenshot
import java.io.IOException

fun takeScreenshot(parentFolderPath: String = "", screenShotName: String) {
    Log.d(TAG, "Taking screenshot of '$screenShotName'")
    val screenCapture = Screenshot.capture()
    val processors = setOf(MyScreenCaptureProcessor(parentFolderPath))
    try {
        screenCapture.apply {
            name = screenShotName
            process(processors)
        }
        Log.d(TAG, "Screenshot taken")
    } catch (ex: IOException) {
        Log.e(TAG, "Could not take a screenshot", ex)
    }
}

fun takeSuccessScreenshot(className: String?, methodName: String) {
//    UiThreadStatement.runOnUiThread {
    takeScreenshot(parentFolderPath = "successes/$className", screenShotName = methodName)
//        Thread.sleep(MILLIS_TO_WAIT_FOR_SCREENSHOT)
//    }
}

fun takeFailureScreenshot(className: String?, methodName: String) {
//    UiThreadStatement.runOnUiThread {
    takeScreenshot(parentFolderPath = "failures/$className", screenShotName = methodName)
//        Thread.sleep(MILLIS_TO_WAIT_FOR_SCREENSHOT)
//    }
}

private const val TAG = "Screenshots"
//private const val MILLIS_TO_WAIT_FOR_SCREENSHOT: Long = 500
