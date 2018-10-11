package com.heitorcolangelo.kappuccino.core;

import android.support.test.espresso.matcher.ViewMatchers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VisibilityAssertionTest {

    private VisibilityAssertion visibilityAssertion;

    @Before
    public void setUp() {
        visibilityAssertion = new VisibilityAssertion();
    }

    @Test
    public void getViewMatcher_returnsIsDisplayed() {
        assertEquals(ViewMatchers.isDisplayed().toString(), visibilityAssertion.getViewMatcher().toString());
    }

    @Test
    public void displayed_shouldCall_visibilityAssertionGetViewAssertion_TRUE() {
        VisibilityAssertion visibilityAssertion = mock(VisibilityAssertion.class);
        VisibilityAssertion.Displayed displayed = new VisibilityAssertion.Displayed(visibilityAssertion);

        displayed.getViewAssertion();

        verify(visibilityAssertion).getViewAssertion(true);
    }

    @Test
    public void notDisplayed_shouldCall_visibilityAssertionGetViewAssertion_FALSE() {
        VisibilityAssertion visibilityAssertion = mock(VisibilityAssertion.class);
        VisibilityAssertion.NotDisplayed notDisplayed = new VisibilityAssertion.NotDisplayed(visibilityAssertion);

        notDisplayed.getViewAssertion();

        verify(visibilityAssertion).getViewAssertion(false);
    }

}