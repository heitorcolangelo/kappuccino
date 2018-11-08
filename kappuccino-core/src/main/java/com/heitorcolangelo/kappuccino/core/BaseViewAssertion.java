package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.ViewAssertion;
import android.view.View;

import org.hamcrest.Matcher;

import javax.annotation.ParametersAreNonnullByDefault;

import static android.support.test.espresso.Espresso.onView;

@SuppressWarnings("WeakerAccess")
@ParametersAreNonnullByDefault
public abstract class BaseViewAssertion<T> implements ViewMatcherMethod<T> {

    private final ViewMatcherMethods viewMatcherMethods = viewMatcherMethodsInstance();

    @Override
    public @NonNull T id(int viewId) {
        check(viewMatcherMethods.id(viewId));
        return getInstance();
    }

    @Override
    public @NonNull T text(int textId) {
        check(viewMatcherMethods.text(textId));
        return getInstance();
    }

    @Override
    public @NonNull T text(String text) {
        check(viewMatcherMethods.text(text));
        return getInstance();
    }

    @Override
    public @NonNull T text(Matcher<String> textMatcher) {
        check(viewMatcherMethods.text(textMatcher));
        return getInstance();
    }

    @Override
    public @NonNull T contentDescription(int contentDescriptionId) {
        check(viewMatcherMethods.contentDescription(contentDescriptionId));
        return getInstance();
    }

    @Override
    public @NonNull T contentDescription(String contentDescription) {
        check(viewMatcherMethods.contentDescription(contentDescription));
        return getInstance();
    }

    @Override
    public @NonNull T contentDescription(Matcher<CharSequence> contentDescriptionMatcher) {
        check(viewMatcherMethods.contentDescription(contentDescriptionMatcher));
        return getInstance();
    }

    @Override
    public @NonNull T custom(Matcher<View> viewMatcher) {
        check(viewMatcher);
        return getInstance();
    }

    @Override
    public @NonNull T allOf(AllOfViewMatcher allOfMatcher) {
        check(viewMatcherMethods.allOf(allOfMatcher));
        return getInstance();
    }

    protected abstract @NonNull ViewAssertion getViewAssertion();

    protected abstract @NonNull T getInstance();

    protected abstract @NonNull ViewMatcherMethods viewMatcherMethodsInstance();

    @VisibleForTesting
    protected void check(Matcher<View> viewMatcher) {
        onView(viewMatcher).check(getViewAssertion());
    }

}