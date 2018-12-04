package com.example.fastlanex.screenshot

import android.os.Environment.DIRECTORY_PICTURES
import android.os.Environment.getExternalStoragePublicDirectory
import androidx.test.runner.screenshot.BasicScreenCaptureProcessor
import com.example.fastlanex.BuildConfig
import java.io.File

class MyScreenCaptureProcessor(parentFolderPath: String) : BasicScreenCaptureProcessor() {

    init {
        this.mDefaultScreenshotPath = File(
            File(
                getExternalStoragePublicDirectory(DIRECTORY_PICTURES),
                BuildConfig.SCREENSHOT_FOLDER
            ).absolutePath,
            "screenshots/$parentFolderPath"
        )
    }

    override fun getFilename(prefix: String): String = prefix
}
