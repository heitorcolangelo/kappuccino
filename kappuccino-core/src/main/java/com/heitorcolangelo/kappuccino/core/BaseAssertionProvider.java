package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.NonNull;
import android.support.test.espresso.ViewAssertion;
import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.not;

public abstract class BaseAssertionProvider {

    @NonNull ViewAssertion getViewAssertion(boolean assertionValue) {
        if (assertionValue) {
            return matches(getViewMatcher());
        } else {
            return matches(not(getViewMatcher()));
        }
    }

    public abstract @NonNull Matcher<View> getViewMatcher();

}