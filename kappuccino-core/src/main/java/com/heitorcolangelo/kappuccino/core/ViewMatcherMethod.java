package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.View;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import javax.annotation.ParametersAreNonnullByDefault;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@ParametersAreNonnullByDefault
public class ViewMatcherMethod implements ViewMatcherMethods<Matcher<View>> {

    @Override
    public @NonNull Matcher<View> id(@IdRes int viewId) {
        return withId(viewId);
    }

    @Override
    public @NonNull Matcher<View> text(@StringRes int textId) {
        return withText(textId);
    }

    @Override
    public @NonNull Matcher<View> text(String text) {
        return withText(text);
    }

    @Override
    public @NonNull Matcher<View> text(Matcher<String> textMatcher) {
        return withText(textMatcher);
    }

    @Override
    public @NonNull Matcher<View> contentDescription(@StringRes int contentDescriptionId) {
        return withContentDescription(contentDescriptionId);
    }

    @Override
    public @NonNull Matcher<View> contentDescription(String contentDescription) {
        return withContentDescription(contentDescription);
    }

    @Override
    public @NonNull Matcher<View> contentDescription(Matcher<CharSequence> contentDescriptionMatcher) {
        return withContentDescription(contentDescriptionMatcher);
    }

    @Override
    public @NonNull Matcher<View> custom(Matcher<View> viewMatcher) {
        return viewMatcher;
    }

    @Override
    public @NonNull Matcher<View> allOf(AllOfViewMatcher viewMatchers) {
        return Matchers.allOf(viewMatchers.getViewMatchers());
    }

}