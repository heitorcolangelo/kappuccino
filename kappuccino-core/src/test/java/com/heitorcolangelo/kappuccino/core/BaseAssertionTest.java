package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.NonNull;
import android.support.test.espresso.ViewAssertion;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Test;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;

public class BaseAssertionTest {

    @Test
    public void getViewAssertion() {

        final Matcher<View> viewMatcher = isDisplayed();

        BaseAssertion assertionProvider = new BaseAssertion() {
            @NonNull @Override public Matcher<View> getViewMatcher() {
                return viewMatcher;
            }
        };

        assertEquals(assertionProvider.getViewAssertion(true).toString(), matches(viewMatcher).toString());

        final ViewAssertion notViewMatcher = matches(not(viewMatcher));
        assertEquals(assertionProvider.getViewAssertion(false).toString(), notViewMatcher.toString());
    }

}