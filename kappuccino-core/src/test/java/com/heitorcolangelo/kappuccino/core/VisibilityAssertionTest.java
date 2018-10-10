package com.heitorcolangelo.kappuccino.core;

import android.support.test.espresso.matcher.ViewMatchers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class VisibilityAssertionTest {

    private VisibilityAssertion visibilityAssertion;

    @Before
    public void setUp() throws Exception {
        visibilityAssertion = new VisibilityAssertion();
    }

    @Test
    public void getViewMatcher() {
        assertTrue(ViewMatchers.isDisplayed().equals(visibilityAssertion.getViewMatcher()));
    }
}