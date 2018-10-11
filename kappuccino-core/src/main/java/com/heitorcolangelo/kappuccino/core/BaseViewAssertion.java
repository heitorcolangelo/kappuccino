package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.ViewAssertion;
import android.view.View;

import org.hamcrest.Matcher;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("WeakerAccess")
@ParametersAreNonnullByDefault
public abstract class BaseViewAssertion<T> implements ViewMatcherMethods<T> {

    ViewMatcherMethod viewMatcherMethod = new ViewMatcherMethod();

    @Override
    public @NonNull T id(int viewId) {
        check(viewMatcherMethod.id(viewId));
        return getInstance();
    }

    @Override
    public @NonNull T text(int textId) {
        check(viewMatcherMethod.text(textId));
        return getInstance();
    }

    @Override
    public @NonNull T text(String text) {
        return getInstance();
    }

    @Override
    public @NonNull T text(Matcher<String> textMatcher) {
        return getInstance();
    }

    @Override
    public @NonNull T contentDescription(int contentDescriptionId) {
        return getInstance();
    }

    @Override
    public @NonNull T contentDescription(String contentDescription) {
        return getInstance();
    }

    @Override
    public @NonNull T contentDescription(Matcher<CharSequence> contentDescriptionMatcher) {
        return getInstance();
    }

    @Override
    public @NonNull T custom(Matcher<View> viewMatcher) {
        return getInstance();
    }

    abstract @NonNull ViewAssertion getViewAssertion();

    abstract @NonNull T getInstance();

    @VisibleForTesting
    void check(Matcher<View> viewMatcher) {
        new ViewInteractionProcessor(viewMatcher).check(getViewAssertion());
    }

}