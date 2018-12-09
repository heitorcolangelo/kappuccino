package com.heitorcolangelo.kappuccino.core.utils;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public abstract class StubbedObjects {

    public static BaseMatcher<String> stringMatcher() {
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

    public static BaseMatcher<CharSequence> charSequenceMatcher() {
        return new BaseMatcher<CharSequence>() {
            @Override public boolean matches(Object item) {
                return false;
            }

            @Override public void describeTo(Description description) {

            }
        };
    }

}