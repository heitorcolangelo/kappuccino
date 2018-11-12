package com.heitorcolangelo.kappuccino.core;

import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

public class AllOfViewMatcherTest {

    @Mock private ViewMatcherMethods matcherMethods;
    @Mock private List<Matcher<? super View>> viewMatchers;

    private AllOfViewMatcher viewMatcher;

    @Before
    public void setUp() {
        viewMatcher = new AllOfViewMatcher(matcherMethods, viewMatchers);
    }

    @Test
    public void id() {
    }

    @Test
    public void text() {
    }

    @Test
    public void text1() {
    }

    @Test
    public void text2() {
    }

    @Test
    public void contentDescription() {
    }

    @Test
    public void contentDescription1() {
    }

    @Test
    public void contentDescription2() {
    }

    @Test
    public void custom() {
    }

    @Test
    public void allOf() {
    }

    @Test
    public void getMatchers() {
    }

}