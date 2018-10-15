package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.NonNull;
import android.view.View;

import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class AllOfViewMatcher implements ViewMatcherMethods<AllOfViewMatcher> {

    final ViewMatcherMethod viewMatcherMethod = new ViewMatcherMethod();
    private final List<Matcher<View>> allOfMatchers = new ArrayList<>();

    @Override
    public @NonNull AllOfViewMatcher id(int viewId) {
        allOfMatchers.add(viewMatcherMethod.id(viewId));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher text(int textId) {
        allOfMatchers.add(viewMatcherMethod.text(textId));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher text(String text) {
        allOfMatchers.add(viewMatcherMethod.text(text));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher text(Matcher<String> textMatcher) {
        allOfMatchers.add(viewMatcherMethod.text(textMatcher));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher contentDescription(int contentDescriptionId) {
        allOfMatchers.add(viewMatcherMethod.contentDescription(contentDescriptionId));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher contentDescription(String contentDescription) {
        allOfMatchers.add(viewMatcherMethod.contentDescription(contentDescription));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher contentDescription(Matcher<CharSequence> contentDescriptionMatcher) {
        allOfMatchers.add(viewMatcherMethod.contentDescription(contentDescriptionMatcher));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher custom(Matcher<View> viewMatcher) {
        allOfMatchers.add(viewMatcherMethod.custom(viewMatcher));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher allOf(AllOfViewMatcher viewMatchers) {
        allOfMatchers.add(viewMatcherMethod.allOf(viewMatchers));
        return this;
    }

    @NonNull Matcher<View>[] getViewMatchers() {
        //noinspection unchecked
        return (Matcher<View>[]) allOfMatchers.toArray();
    }

}