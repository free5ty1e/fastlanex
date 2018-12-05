package com.example.fastlanex

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class InstrumentedContextTest {

    @Test
    fun listRootAssets() {
        // Context of the app under test.
        val appContext = context()
        assertNotNull(appContext)
        val assetsListRoot = appContext.assets.list("./")
        assertNotNull(assetsListRoot)
        System.out.println("appContext.assets.list: $assetsListRoot")
    }

    private fun context() = InstrumentationRegistry.getInstrumentation().context

    @Test
    @SmallTest
    fun useAppContext() {
        // Context of the app under test.
        val appContext = context()
        assertNotNull(appContext)
        assertEquals(BuildConfig.APPLICATION_ID + ".test", appContext.packageName)
    }
}
