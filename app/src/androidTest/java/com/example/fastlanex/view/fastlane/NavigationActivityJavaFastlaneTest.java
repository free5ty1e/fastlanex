package com.example.fastlanex.view.fastlane;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.example.fastlanex.R;
import com.example.fastlanex.view.activities.NavigationActivity;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy;
import tools.fastlane.screengrab.locale.LocaleTestRule;

@RunWith(AndroidJUnit4.class)
public class NavigationActivityJavaFastlaneTest {

    @ClassRule
    public static final LocaleTestRule localeTestRule = new LocaleTestRule();

    @Rule
    public ActivityTestRule<NavigationActivity> activityRule = new ActivityTestRule<>(NavigationActivity.class);

    @BeforeClass
    public static void beforeAll() {
        Screengrab.setDefaultScreenshotStrategy(new UiAutomatorScreenshotStrategy());
    }

    @Test
    public void testTakeScreenshot() {
        ViewInteraction bottomNavigationItemView3 = Espresso.onView(
                Matchers.allOf(
                        ViewMatchers.withId(R.id.navigation_notifications),
                        ViewMatchers.withContentDescription("Notifications"),
                        ViewMatchers.isDisplayed()
                )
        );
        bottomNavigationItemView3.perform(ViewActions.click());

        ViewInteraction textView4 = Espresso.onView(
                Matchers.allOf(
                        ViewMatchers.withId(R.id.settings_message), ViewMatchers.withText(Matchers.containsString("Notifications")),
                        ViewMatchers.isDisplayed()
                )
        );
        textView4.check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString("Notifications"))));

        Screengrab.screenshot("testScreenshot");
    }
}
