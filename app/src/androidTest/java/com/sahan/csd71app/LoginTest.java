package com.sahan.csd71app;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.sahan.csd71app.view.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> activityScenarioRule =
            new ActivityScenarioRule<LoginActivity>(LoginActivity.class);

    @Test
    public void testLoginUI(){
        onView(withId(R.id.etEmail)).perform(typeText("shehara@gmail.com"));
        onView(withId(R.id.etPass)).perform(typeText("123456"));
        closeSoftKeyboard();
        onView(withId(R.id.btnSignIn)).perform(click());
    }

}
