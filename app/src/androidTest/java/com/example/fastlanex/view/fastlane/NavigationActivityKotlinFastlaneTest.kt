package com.example.fastlanex.view.fastlane

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.fastlanex.view.activities.NavigationActivity
import org.hamcrest.Matchers
import org.hamcrest.core.StringContains
import org.junit.BeforeClass
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy
import tools.fastlane.screengrab.locale.LocaleTestRule

@RunWith(AndroidJUnit4::class)
class NavigationActivityKotlinFastlaneTest {

    @JvmField
    @Rule
    var activityRule = ActivityTestRule(NavigationActivity::class.java)

    @Test
    fun testTakeScreenshot() {
        val textView6 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withText(StringContains("oobe")),
                ViewMatchers.isDisplayed()
            )
        )
        textView6.check(ViewAssertions.matches(ViewMatchers.withText(StringContains("oobe"))))

        Screengrab.screenshot("testScreenshotKotlin")
    }

    companion object {

        @JvmField
        @ClassRule
        val localeTestRule = LocaleTestRule()

        @BeforeClass
        fun beforeAll() {
            Screengrab.setDefaultScreenshotStrategy(UiAutomatorScreenshotStrategy())
        }
    }
}
