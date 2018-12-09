package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.heitorcolangelo.kappuccino.core.utils.StubbedObjects.charSequenceMatcher;
import static com.heitorcolangelo.kappuccino.core.utils.StubbedObjects.stringMatcher;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ViewMatcherMethodsTest {

    @IdRes private static final int ID = 123;
    @StringRes private static final int STRING_RES = 321;
    private static final String TEXT = "TEXT";

    private ViewMatcherMethods viewMatcherMethods;

    @Before
    public void setUp() {
        viewMatcherMethods = new ViewMatcherMethods();
    }

    @Test
    public void id() {
        Matcher<View> withIdMatcher = withId(ID);

        Matcher<View> id = viewMatcherMethods.id(ID);

        assertEquals(withIdMatcher.toString(), id.toString());
    }

    @Test
    public void text_stringRes() {
        Matcher<View> withTextMatcher = withText(STRING_RES);

        Matcher<View> text = viewMatcherMethods.text(STRING_RES);

        assertEquals(withTextMatcher.toString(), text.toString());

    }

    @Test
    public void text_string() {
        Matcher<View> withTextMatcher = withText(TEXT);

        Matcher<View> text = viewMatcherMethods.text(TEXT);

        assertEquals(withTextMatcher.toString(), text.toString());
    }

    @Test
    public void text_stringMatcher() {
        Matcher<View> textMatcherMock = withText(stringMatcher());

        Matcher<View> text = viewMatcherMethods.text(stringMatcher());

        assertEquals(textMatcherMock.toString(), text.toString());
    }

    @Test
    public void contentDescription_stringRes() {
        Matcher<View> withContentDescriptionMatcher = withContentDescription(STRING_RES);

        Matcher<View> contentDescription = viewMatcherMethods.contentDescription(STRING_RES);

        assertEquals(withContentDescriptionMatcher.toString(), contentDescription.toString());
    }

    @Test
    public void contentDescription_string() {
        Matcher<View> withContentDescriptionMatcher = withContentDescription(TEXT);

        Matcher<View> contentDescription = viewMatcherMethods.contentDescription(TEXT);

        assertEquals(withContentDescriptionMatcher.toString(), contentDescription.toString());
    }

    @Test
    public void contentDescription_charSequenceMather() {
        Matcher<View> withContentDescriptionMatcher = withContentDescription(charSequenceMatcher());

        Matcher<View> contentDescription = viewMatcherMethods.contentDescription(charSequenceMatcher());

        assertEquals(withContentDescriptionMatcher.toString(), contentDescription.toString());
    }

    @Test
    public void custom() {
        //noinspection unchecked
        Matcher<View> customMatcherMock = (Matcher<View>) mock(Matcher.class);

        Matcher<View> custom = viewMatcherMethods.custom(customMatcherMock);

        assertEquals(customMatcherMock.toString(), custom.toString());

    }

}