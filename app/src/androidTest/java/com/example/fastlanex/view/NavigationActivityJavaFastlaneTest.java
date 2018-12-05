package com.example.fastlanex.view;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.fastlanex.view.activities.NavigationActivity;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.UiAutomatorScreenshotStrategy;
import tools.fastlane.screengrab.locale.LocaleTestRule;

//import android.support.test.rule.ActivityTestRule;
import androidx.test.rule.ActivityTestRule;

//@RunWith(JUnit4.class)
//@RunWith(AndroidJUnit4.class)
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
        Screengrab.screenshot("beforeFabClick");
    }
}
