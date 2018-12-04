package com.example.fastlanex.screenshot

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.app.Activity
import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import org.junit.After
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy
import tools.fastlane.screengrab.locale.LocaleTestRule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
abstract class BaseUiScreenshotTest<T : Activity>(private val clazz: Class<T>) {

    //TODO: Update to utilize the new ActivityScenario without breaking screenshots (using ActivityTestRule instead allows for @RuleChain to ensure the activity doesn't end until the screenshot is triggered from the TestWatcher implementation
//    var scenario : ActivityScenario<T>? = null

/*
    private inline fun <reified T: Activity> startActivityScenario() {
        scenario = ActivityScenario.launch(T::class.java)
    }
*/

/*
    inline fun <reified R: T> startActivityScenario() {
        scenario = ActivityScenario.launch(T::class.java)
    }
*/

/*
    object MyActivityTestRule : ActivityTestRule<MainActivity>(MainActivity::class.java, true, false) {
        override fun beforeActivityLaunched() {
            super.beforeActivityLaunched()
        }

        override fun afterActivityLaunched() {
            super.afterActivityLaunched()
        }

        override fun afterActivityFinished() {
            super.afterActivityFinished()
        }
    }
*/

    val activityTestRule: ActivityTestRule<T> = ActivityTestRule<T>(clazz)

    //    val testName = TestName()
    val grantPermissionRule = GrantPermissionRule.grant(READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE)
    var screenshotTakingRule: ScreenshotTakingRule = ScreenshotTakingRule()

    /*
        @JvmField
        @Rule
        var screenshotTakingRule: ScreenshotTakingRule<T>? = ScreenshotTakingRule(scenario)
    */

    @get:ClassRule val localeTestRule = LocaleTestRule()

    @JvmField
    @Rule
    val ruleChain: RuleChain = RuleChain
            .outerRule(activityTestRule)
            .around(grantPermissionRule)
//            .around(LocaleTestRule())
//            .outerRule(grantPermissionRule)
//            .around(testName)
            .around(screenshotTakingRule)

    @Before
    fun setup() {
        // GIVEN
        //given
//        activityTestRule.launchActivity(null)
//        scenario = ActivityScenario.launch(clazz)
//        screenshotTakingRule.scenario = scenario
        Screengrab.setDefaultScreenshotStrategy(UiAutomatorScreenshotStrategy())
    }

    fun getActivity(): T = activityTestRule.activity

    @After
    fun tearDown() {
        Log.d(javaClass.simpleName, "Waiting $MILLIS_TO_WAIT_FOR_SCREENSHOT ms to allow screenshot to capture the correct screen...")
        Thread.sleep(MILLIS_TO_WAIT_FOR_SCREENSHOT)
        Log.d(javaClass.simpleName, "Screenshot should have completed, killing activity...")
    }
}
private const val MILLIS_TO_WAIT_FOR_SCREENSHOT: Long = 500
