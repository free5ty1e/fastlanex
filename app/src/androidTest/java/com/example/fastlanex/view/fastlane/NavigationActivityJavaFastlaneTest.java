package com.example.fastlanex.view.fastlane;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import com.example.fastlanex.R;
import com.example.fastlanex.view.activities.NavigationActivity;
import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.runner.RunWith;
import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy;
import tools.fastlane.screengrab.locale.LocaleTestRule;

@Ignore(NavigationActivityJavaFastlaneTest.IGNORE_REASON)
@RunWith(AndroidJUnit4.class)
public class NavigationActivityJavaFastlaneTest {
    static final String IGNORE_REASON = "This test is only intended for running via fastlane screengrab, where the test runner is manually managed";

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
