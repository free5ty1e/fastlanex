package com.example.fastlanex.view.fastlane

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.fastlanex.R
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

        val bottomNavigationItemView3 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.navigation_notifications),
                ViewMatchers.withContentDescription("Notifications"),
                ViewMatchers.isDisplayed()
            )
        )
        bottomNavigationItemView3.perform(ViewActions.click())

        val textView4 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.settings_message), ViewMatchers.withText(Matchers.containsString("Notifications")),
                ViewMatchers.isDisplayed()
            )
        )
        textView4.check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString("Notifications"))))

        Screengrab.screenshot("testScreenshotNotificationsKotlin")
    }

    companion object {

        @JvmField
        @ClassRule
        val localeTestRule = LocaleTestRule()

        @Suppress("unused")
        @BeforeClass
        fun beforeAll() {
            Screengrab.setDefaultScreenshotStrategy(UiAutomatorScreenshotStrategy())
        }
    }
}
