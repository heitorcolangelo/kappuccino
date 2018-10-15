package com.heitorcolangelo.kappuccino;

import android.support.test.rule.ActivityTestRule;

import com.heitorcolangelo.kappuccino.core.AllOfViewMatcher;

import org.junit.Rule;
import org.junit.Test;

import br.com.concretesolutions.kappuccino.sample.R;
import br.com.concretesolutions.kappuccino.sample.VisibilityAssertionsActivity;

import static com.heitorcolangelo.kappuccino.core.VisibilityAssertion.displayed;
import static com.heitorcolangelo.kappuccino.core.VisibilityAssertion.notDisplayed;

public class VisibilityActivityTestJava {
    @Rule
    public ActivityTestRule<VisibilityAssertionsActivity>
            rule = new ActivityTestRule<>(VisibilityAssertionsActivity.class, false, true);

    @Test
    public void newTestMethod() {

        displayed()
                .id(R.id.txt_visible)
                .allOf(new AllOfViewMatcher()
                        .id(R.id.txt_visible));

        notDisplayed()
                .id(R.id.txt_invisible);
    }
}
