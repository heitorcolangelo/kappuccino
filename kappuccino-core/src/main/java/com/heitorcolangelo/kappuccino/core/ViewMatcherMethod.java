package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Matcher;

import javax.annotation.ParametersAreNonnullByDefault;

import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@ParametersAreNonnullByDefault
public class ViewMatcherMethod implements ViewMatcherMethods<Matcher<View>> {

    /**
     * Match view based on view Id.
     * <p>
     * It will call {@link ViewMatchers#withId(int)}
     */
    @Override
    public @NonNull Matcher<View> id(@IdRes int viewId) {
        return withId(viewId);
    }

    /**
     * Match a view based on {@link StringRes} text.
     * <p>
     * It will call {@link ViewMatchers#withText(int)}
     */
    @Override
    public @NonNull Matcher<View> text(@StringRes int textId) {
        return withText(textId);
    }

    /**
     * Match a view based on custom {@link String}text.
     * <p>
     * It will call {@link ViewMatchers#withText(String)}
     */
    @Override
    public @NonNull Matcher<View> text(String text) {
        return withText(text);
    }

    /**
     * Match a view based on {@link Matcher<String>} content description.
     * <p>
     * It will call {@link ViewMatchers#withText(Matcher)}
     */
    @Override
    public @NonNull Matcher<View> text(Matcher<String> textMatcher) {
        return withText(textMatcher);
    }

    /**
     * Match a view based on {@link StringRes} content description.
     * <p>
     * It will call {@link ViewMatchers#withContentDescription(int)}
     */
    @Override
    public @NonNull Matcher<View> contentDescription(@StringRes int contentDescriptionId) {
        return withContentDescription(contentDescriptionId);
    }

    /**
     * Match a view based on {@link String} content description.
     * <p>
     * It will call {@link ViewMatchers#withContentDescription(String)}
     */
    @Override
    public @NonNull Matcher<View> contentDescription(String contentDescription) {
        return withContentDescription(contentDescription);
    }

    /**
     * Match a view based on {@link Matcher<CharSequence>} content description.
     * <p>
     * It will call {@link ViewMatchers#withContentDescription(Matcher)}
     */

    @Override
    public @NonNull Matcher<View> contentDescription(Matcher<CharSequence> contentDescriptionMatcher) {
        return withContentDescription(contentDescriptionMatcher);
    }

    /**
     * Match a view based on the custom matcher passed as parameter
     */
    @Override
    public @NonNull Matcher<View> custom(Matcher<View> viewMatcher) {
        return viewMatcher;
    }

}