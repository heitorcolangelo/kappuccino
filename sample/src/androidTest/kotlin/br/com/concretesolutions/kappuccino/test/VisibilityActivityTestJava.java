package br.com.concretesolutions.kappuccino.test;

import android.support.test.rule.ActivityTestRule;

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
                .id(R.id.txt_visible);

        notDisplayed()
                .id(R.id.txt_invisible);
    }
}
