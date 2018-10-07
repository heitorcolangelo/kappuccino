package com.heitorcolangelo.kappuccino.sample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.heitorcolangelo.kappuccino.core.ViewMatcherMethod.id;
import static com.heitorcolangelo.kappuccino.core.ViewMatcherMethod.text;
import static com.heitorcolangelo.kappuccino.java.assertion.VisibilityAssertion.displayed;
import static com.heitorcolangelo.kappuccino.java.assertion.VisibilityAssertion.notDisplayed;

@RunWith(AndroidJUnit4.class)
public class VisibilityAssertionActivityTest {

    @Rule
    public ActivityTestRule<VisibilityAssertionActivity> rule =
            new ActivityTestRule<>(VisibilityAssertionActivity.class, false, true);

    @Test
    public void displayedMethodTest() {
        displayed(
                id(R.id.visible_text_view),
                text(R.string.app_name)
        );

        notDisplayed(
                id(R.id.not_visible_text_view)
        );
    }
}