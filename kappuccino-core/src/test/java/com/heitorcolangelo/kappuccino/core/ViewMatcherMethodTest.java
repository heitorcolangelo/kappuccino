package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.View;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@SuppressWarnings("unchecked")
public class ViewMatcherMethodTest {

    @IdRes private static final int ID = 123;
    @StringRes private static final int STRING_RES = 321;
    private static final String TEXT = "TEXT";

    private ViewMatcherMethod viewMatcherMethod;

    @Before
    public void setUp() {
        viewMatcherMethod = new ViewMatcherMethod();
    }

    @Test
    public void id() {
        Matcher<View> withIdMatcher = withId(ID);

        Matcher<View> id = viewMatcherMethod.id(ID);

        assertEquals(withIdMatcher.toString(), id.toString());
    }

    @Test
    public void text_stringRes() {
        Matcher<View> withTextMatcher = withText(STRING_RES);

        Matcher<View> text = viewMatcherMethod.text(STRING_RES);

        assertEquals(withTextMatcher.toString(), text.toString());

    }

    @Test
    public void text_string() {
        Matcher<View> withTextMatcher = withText(TEXT);

        Matcher<View> text = viewMatcherMethod.text(TEXT);

        assertEquals(withTextMatcher.toString(), text.toString());
    }

    @Test
    public void text_stringMatcher() {
        Matcher<View> textMatcherMock = withText(stubStringMatcher());

        Matcher<View> text = viewMatcherMethod.text(stubStringMatcher());

        assertEquals(textMatcherMock.toString(), text.toString());
    }

    @Test
    public void contentDescription_stringRes() {
        Matcher<View> withContentDescriptionMatcher = withContentDescription(STRING_RES);

        Matcher<View> contentDescription = viewMatcherMethod.contentDescription(STRING_RES);

        assertEquals(withContentDescriptionMatcher.toString(), contentDescription.toString());
    }

    @Test
    public void contentDescription_string() {
        Matcher<View> withContentDescriptionMatcher = withContentDescription(TEXT);

        Matcher<View> contentDescription = viewMatcherMethod.contentDescription(TEXT);

        assertEquals(withContentDescriptionMatcher.toString(), contentDescription.toString());
    }

    @Test
    public void contentDescription_charSequenceMather() {
        Matcher<View> withContentDescriptionMatcher = withContentDescription(stubCharSequenceMatcher());

        Matcher<View> contentDescription = viewMatcherMethod.contentDescription(stubCharSequenceMatcher());

        assertEquals(withContentDescriptionMatcher.toString(), contentDescription.toString());
    }

    @Test
    public void custom() {
        Matcher<View> customMatcherMock = (Matcher<View>) mock(Matcher.class);

        Matcher<View> custom = viewMatcherMethod.custom(customMatcherMock);

        assertEquals(customMatcherMock.toString(), custom.toString());

    }

    private BaseMatcher<String> stubStringMatcher() {
        return new BaseMatcher<String>() {
            @Override public boolean matches(Object item) {
                return false;
            }

            @Override public void describeMismatch(Object item, Description mismatchDescription) {

            }

            @Override public void describeTo(Description description) {

            }
        };
    }

    private BaseMatcher<CharSequence> stubCharSequenceMatcher() {
        return new BaseMatcher<CharSequence>() {
            @Override public boolean matches(Object item) {
                return false;
            }

            @Override public void describeTo(Description description) {

            }
        };
    }

}