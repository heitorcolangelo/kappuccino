package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.View;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.heitorcolangelo.kappuccino.core.utils.StubbedObjects.charSequenceMatcher;
import static com.heitorcolangelo.kappuccino.core.utils.StubbedObjects.stringMatcher;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SuppressWarnings("unchecked")
public class AllOfViewMatcherTest {

    @IdRes private static final int ID = 123;
    @StringRes private static final int STRING_RES = 321;
    private static final String TEXT = "TEXT";

    @Mock private ViewMatcherMethods matcherMethods;
    @Mock private List<Matcher<? super View>> matcherList;
    @Mock private Matcher<View> matcherMock;

    private AllOfViewMatcher allOfViewMatcher;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        allOfViewMatcher = new AllOfViewMatcher(matcherMethods, matcherList);
    }

    @Test
    public void id() {
        when(matcherMethods.id(ID)).thenReturn(matcherMock);

        allOfViewMatcher.id(ID);

        verify(matcherMethods).id(ID);
        verify(matcherList).add(matcherMock);
    }

    @Test
    public void text_stringRes() {
        when(matcherMethods.text(STRING_RES)).thenReturn(matcherMock);

        allOfViewMatcher.text(STRING_RES);

        verify(matcherMethods).text(STRING_RES);
        verify(matcherList).add(matcherMock);
    }

    @Test
    public void text_string() {
        when(matcherMethods.text(TEXT)).thenReturn(matcherMock);

        allOfViewMatcher.text(TEXT);

        verify(matcherMethods).text(TEXT);
        verify(matcherList).add(matcherMock);
    }

    @Test
    public void text_stringMatcher() {
        BaseMatcher<String> stringMatcher = stringMatcher();
        when(matcherMethods.text(stringMatcher)).thenReturn(matcherMock);

        allOfViewMatcher.text(stringMatcher);

        verify(matcherMethods).text(stringMatcher);
        verify(matcherList).add(matcherMock);
    }

    @Test
    public void contentDescription_stringRes() {
        when(matcherMethods.contentDescription(STRING_RES)).thenReturn(matcherMock);

        allOfViewMatcher.contentDescription(STRING_RES);

        verify(matcherMethods).contentDescription(STRING_RES);
        verify(matcherList).add(matcherMock);
    }

    @Test
    public void contentDescription_string() {
        when(matcherMethods.contentDescription(TEXT)).thenReturn(matcherMock);

        allOfViewMatcher.contentDescription(TEXT);

        verify(matcherMethods).contentDescription(TEXT);
        verify(matcherList).add(matcherMock);
    }

    @Test
    public void contentDescription_charSequenceMatcher() {
        BaseMatcher<CharSequence> charSequenceMatcher = charSequenceMatcher();
        when(matcherMethods.contentDescription(charSequenceMatcher)).thenReturn(matcherMock);

        allOfViewMatcher.contentDescription(charSequenceMatcher);

        verify(matcherMethods).contentDescription(charSequenceMatcher);
        verify(matcherList).add(matcherMock);
    }

    @Test
    public void custom() {
        when(matcherMethods.custom(matcherMock)).thenReturn(matcherMock);

        allOfViewMatcher.custom(matcherMock);

        verify(matcherMethods).custom(matcherMock);
        verify(matcherList).add(matcherMock);
    }

    @Test
    public void allOf() {
        AllOfViewMatcher allOfMock = mock(AllOfViewMatcher.class);
        when(matcherMethods.allOf(allOfMock)).thenReturn(matcherMock);

        allOfViewMatcher.allOf(allOfMock);

        verify(matcherMethods).allOf(allOfMock);
        verify(matcherList).add(matcherMock);
    }

}