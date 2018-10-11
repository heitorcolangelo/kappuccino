package com.heitorcolangelo.kappuccino.core;


import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.test.espresso.ViewAssertion;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import javax.annotation.ParametersAreNonnullByDefault;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.RETURNS_DEFAULTS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BaseViewAssertionTest {

    @IdRes private static final int TEST_ID = 123;
    @StringRes private static final int TEST_STRING_RES = 321;
    private static final String TEST_TEXT = "TEXT";

    private ViewMatcherMethod viewMatcherMethodMock;
    private BaseViewAssertion baseViewAssertion;

    @Before
    public void setUp() {
        final Matcher matcher = withId(TEST_ID);

        viewMatcherMethodMock = mock(ViewMatcherMethod.class, new Answer() {
            @Override public Object answer(InvocationOnMock invocation) throws Throwable {
                if (Matcher.class.equals(invocation.getMethod().getReturnType())) {
                    return matcher;
                } else {
                    return RETURNS_DEFAULTS.answer(invocation);
                }
            }
        });

        baseViewAssertion = new TestViewAssertion();

        baseViewAssertion.viewMatcherMethod = this.viewMatcherMethodMock;
    }

    @Test
    public void id() {
        baseViewAssertion.id(TEST_ID);
        verify(viewMatcherMethodMock).id(TEST_ID);
    }

    @Test
    public void text_StringRes() {
        baseViewAssertion.text(TEST_STRING_RES);
        verify(viewMatcherMethodMock).text(TEST_STRING_RES);
    }

    @Test
    public void text_String() {
        baseViewAssertion.text(TEST_TEXT);
        verify(viewMatcherMethodMock).text(TEST_TEXT);
    }

    @Test
    public void text_Matcher() {
    }

    @Test
    public void contentDescription_StringRes() {
    }

    @Test
    public void contentDescription_String() {
    }

    @Test
    public void contentDescription_Matcher() {
    }

    @Test
    public void custom() {
    }

    @ParametersAreNonnullByDefault
    private class TestViewAssertion extends BaseViewAssertion<TestViewAssertion> {
        @NonNull @Override ViewAssertion getViewAssertion() {
            return matches(isDisplayed());
        }

        @NonNull @Override TestViewAssertion getInstance() {
            return this;
        }

        @Override void check(Matcher<View> viewMatcher) {
        }
    }

}