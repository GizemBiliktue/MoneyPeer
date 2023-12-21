package com.example.moneypeer;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import com.example.moneypeer.R;
import com.example.moneypeer.WillkommenActivity;

@RunWith(AndroidJUnit4.class)
public class TestWillkommenActivity {

    @Test
    public void testEmptyName() {
        // Klick auf den Weiter-Button mit leerem Namen
        Espresso.onView(ViewMatchers.withId(R.id.weiterButton)).perform(ViewActions.click());

        // Überprüfung, ob der Toast mit der entsprechenden Nachricht angezeigt wird
        Espresso.onView(withText("Bitte gib einen Namen ein. "))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    @Test
    public void testNameWithNumbers() {
        ActivityScenario.launch(WillkommenActivity.class);

        // Simulate name with numbers
        onView(withId(R.id.editNameText)).perform(replaceText("John123"));
        onView(withId(R.id.weiterButton)).perform(click());

        // Check if the toast is displayed
        onView(withText("Der Name darf keine Zahlen enthalten.")).inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));
    }

    @Test
    public void testValidName() {
        ActivityScenario.launch(WillkommenActivity.class);

        // Simulate valid name
        onView(withId(R.id.editNameText)).perform(replaceText("JohnDoe"));
        onView(withId(R.id.weiterButton)).perform(click());

        // Check if DashboardActivity started
        // You may verify intents here based on your actual implementation
    }
}
