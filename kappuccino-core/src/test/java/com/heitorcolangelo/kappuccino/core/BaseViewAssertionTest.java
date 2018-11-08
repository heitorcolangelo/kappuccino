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

@SuppressWarnings("unchecked")
public class BaseViewAssertionTest {

    @IdRes private static final int ID = 123;
    @StringRes private static final int STRING_RES = 321;
    private static final String TEXT = "TEXT";

    private ViewMatcherMethods viewMatcherMethodMock;
    private BaseViewAssertion baseViewAssertion;

    @Before
    public void setUp() {
        final Matcher matcher = withId(ID);

        viewMatcherMethodMock = mock(ViewMatcherMethods.class, new Answer() {
            @Override public Object answer(InvocationOnMock invocation) throws Throwable {
                if (Matcher.class.equals(invocation.getMethod().getReturnType())) {
                    return matcher;
                } else {
                    return RETURNS_DEFAULTS.answer(invocation);
                }
            }
        });

        baseViewAssertion = new TestViewAssertion();
    }

    @Test
    public void id() {
        baseViewAssertion.id(ID);
        verify(viewMatcherMethodMock).id(ID);
    }

    @Test
    public void text_StringRes() {
        baseViewAssertion.text(STRING_RES);
        verify(viewMatcherMethodMock).text(STRING_RES);
    }

    @Test
    public void text_String() {
        baseViewAssertion.text(TEXT);
        verify(viewMatcherMethodMock).text(TEXT);
    }

    @Test
    public void text_Matcher() {
        Matcher<String> stringMatcher = (Matcher<String>) mock(Matcher.class);

        baseViewAssertion.text(stringMatcher);
        verify(viewMatcherMethodMock).text(stringMatcher);
    }

    @Test
    public void contentDescription_StringRes() {
        baseViewAssertion.contentDescription(STRING_RES);
        verify(viewMatcherMethodMock).contentDescription(STRING_RES);
    }

    @Test
    public void contentDescription_String() {
        baseViewAssertion.contentDescription(TEXT);
        verify(viewMatcherMethodMock).contentDescription(TEXT);
    }

    @Test
    public void contentDescription_Matcher() {
        Matcher<CharSequence> stringMatcher = (Matcher<CharSequence>) mock(Matcher.class);

        baseViewAssertion.contentDescription(stringMatcher);
        verify(viewMatcherMethodMock).contentDescription(stringMatcher);
    }

    @Test
    public void custom() {
        Matcher<View> viewMatcher = withId(ID);
        // This will not interact with viewMatcherMethodMock.
        // I'll keep this test for documentation and coverage purpose.
        baseViewAssertion.custom(viewMatcher);
    }

    @ParametersAreNonnullByDefault
    private class TestViewAssertion extends BaseViewAssertion<TestViewAssertion> {
        @Override
        protected @NonNull ViewAssertion getViewAssertion() {
            return matches(isDisplayed());
        }

        @Override
        protected @NonNull TestViewAssertion getInstance() {
            return this;
        }

        @Override
        protected void check(Matcher<View> viewMatcher) {
        }

        @Override
        protected @NonNull ViewMatcherMethods viewMatcherMethodsInstance() {
            return viewMatcherMethodMock;
        }
    }

}