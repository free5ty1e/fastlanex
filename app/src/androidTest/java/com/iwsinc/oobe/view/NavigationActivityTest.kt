package com.example.fastlanex.view

import android.support.v7.view.menu.ActionMenuItem
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.fastlanex.R
import com.example.fastlanex.screenshot.BaseUiScreenshotTest
import com.example.fastlanex.view.activities.NavigationActivity
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import tools.fastlane.screengrab.Screengrab.screenshot


@RunWith(AndroidJUnit4::class)
class NavigationActivityTest : BaseUiScreenshotTest<NavigationActivity>(NavigationActivity::class.java) {

//    var scenario: ActivityScenario<NavigationActivity>? = null

/*
    @Before
    fun setup() {
        // GIVEN
        scenario = ActivityScenario.launch(NavigationActivity::class.java)
    }
*/

/*
    @Test
    fun activityStatesTest() {
        scenario!!.onActivity { activity -> Assert.assertNotNull(activity)}
        scenario!!.moveToState(Lifecycle.State.CREATED) // Your activity is paused.
        scenario!!.onActivity { activity -> Assert.assertNotNull(activity)}
        scenario!!.moveToState(Lifecycle.State.STARTED) // Your activity is resumed.
        scenario!!.onActivity { activity -> Assert.assertNotNull(activity)}
        scenario!!.moveToState(Lifecycle.State.CREATED) // Your activity is paused.
        scenario!!.onActivity { activity -> Assert.assertNotNull(activity)}
//        scenario!!.moveToState(Lifecycle.State.DESTROYED)   // Your activity is destroyed and finished.
    }
*/

    @Test
    @SmallTest
    fun navigateToUnknownItemTest() {
        //First navigate to home
        clickTabHome()
        checkHomeScreen()
        val it = getActivity()
//        scenario!!.onActivity {
        it.
                mOnNavigationItemSelectedListener.onNavigationItemSelected(ActionMenuItem(it, 0, 0, 0, 0, "TEST"))
//        }
        checkHomeScreen()
    }


    @Test
    @SmallTest
    fun mainActivityTest() {
        screenshot("start mainActivityTest")
        checkHomeScreen()

        clickTabHome()

        checkHomeScreen()

        val bottomNavigationItemView2 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.navigation_dashboard), ViewMatchers.withContentDescription("Dashboard"),
                ViewMatchers.isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(ViewActions.click())

        val textView3 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.settings_message), ViewMatchers.withText(Matchers.containsString("Dashboard")),
                ViewMatchers.isDisplayed()
            )
        )
        textView3.check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString("Dashboard"))))

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

        clickTabHome()

        checkHomeScreen()

        val textView6 = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withText("oobe"),
                ViewMatchers.isDisplayed()
            )
        )
        textView6.check(ViewAssertions.matches(ViewMatchers.withText("oobe")))
    }

    private fun clickTabHome() {
        val bottomNavigationItemView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.navigation_home), ViewMatchers.withContentDescription("Home"),
                ViewMatchers.isDisplayed()
            )
        )
        bottomNavigationItemView.perform(ViewActions.click())
    }

    private fun checkHomeScreen() {
        val textView = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.settings_message), ViewMatchers.withText(Matchers.containsString("Home")),
                ViewMatchers.isDisplayed()
            )
        )
        textView.check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString("Home"))))
    }

/*
    @After
    fun tearDown() {

    }
*/
}
