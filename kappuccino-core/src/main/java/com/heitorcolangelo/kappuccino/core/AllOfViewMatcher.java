package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.view.View;

import org.hamcrest.Matcher;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("WeakerAccess")
@ParametersAreNonnullByDefault
public class AllOfViewMatcher implements ViewMatcherMethod<AllOfViewMatcher> {

    private final ViewMatcherMethods matcherMethods;
    private final List<Matcher<? super View>> viewMatchers;

    @RestrictTo(RestrictTo.Scope.TESTS)
    AllOfViewMatcher(ViewMatcherMethods matcherMethods, List<Matcher<? super View>> viewMatchers) {
        this.matcherMethods = matcherMethods;
        this.viewMatchers = viewMatchers;
    }

    public AllOfViewMatcher() {
        this.matcherMethods = new ViewMatcherMethods();
        this.viewMatchers = new ArrayList<>();
    }

    @Override
    public @NonNull AllOfViewMatcher id(int viewId) {
        viewMatchers.add(matcherMethods.id(viewId));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher text(int textId) {
        viewMatchers.add(matcherMethods.text(textId));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher text(String text) {
        viewMatchers.add(matcherMethods.text(text));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher text(Matcher<String> textMatcher) {
        viewMatchers.add(matcherMethods.text(textMatcher));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher contentDescription(int contentDescriptionId) {
        viewMatchers.add(matcherMethods.contentDescription(contentDescriptionId));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher contentDescription(String contentDescription) {
        viewMatchers.add(matcherMethods.contentDescription(contentDescription));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher contentDescription(Matcher<CharSequence> contentDescriptionMatcher) {
        viewMatchers.add(matcherMethods.contentDescription(contentDescriptionMatcher));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher custom(Matcher<View> viewMatcher) {
        viewMatchers.add(matcherMethods.custom(viewMatcher));
        return this;
    }

    @Override
    public @NonNull AllOfViewMatcher allOf(AllOfViewMatcher allOfMatcher) {
        viewMatchers.add(matcherMethods.allOf(allOfMatcher));
        return this;
    }

    @NonNull List<Matcher<? super View>> getMatchers() {
        return viewMatchers;
    }

}