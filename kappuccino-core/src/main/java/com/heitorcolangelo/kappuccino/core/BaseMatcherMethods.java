package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Matcher;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface BaseMatcherMethods<T> {

    /**
     * Match view based on view Id.
     * <p>
     * It will call {@link ViewMatchers#withId(int)}
     */
    @NonNull
    T id(@IdRes int viewId);

    /**
     * Match a view based on {@link StringRes} text.
     * <p>
     * It will call {@link ViewMatchers#withText(int)}
     */
    @NonNull
    T text(@StringRes int textId);

    /**
     * Match a view based on custom {@link String}text.
     * <p>
     * It will call {@link ViewMatchers#withText(String)}
     */
    @NonNull
    T text(String text);

    /**
     * Match a view based on {@link Matcher<String>} content description.
     * <p>
     * It will call {@link ViewMatchers#withText(Matcher)}
     */
    @NonNull
    T text(Matcher<String> textMatcher);

    /**
     * Match a view based on {@link StringRes} content description.
     * <p>
     * It will call {@link ViewMatchers#withContentDescription(int)}
     */
    @NonNull
    T contentDescription(@StringRes int contentDescriptionId);

    /**
     * Match a view based on {@link String} content description.
     * <p>
     * It will call {@link ViewMatchers#withContentDescription(String)}
     */
    @NonNull
    T contentDescription(String contentDescription);

    /**
     * Match a view based on {@link Matcher<CharSequence>} content description.
     * <p>
     * It will call {@link ViewMatchers#withContentDescription(Matcher)}
     */
    @NonNull
    T contentDescription(Matcher<CharSequence> contentDescriptionMatcher);

    /**
     * Match a view based on the custom matcher passed as parameter
     */
    @NonNull
    T custom(Matcher<View> viewMatcher);

    /**
     * Match a view based on the combination of all matchers passed as parameter
     */
    @SuppressWarnings("unchecked")
    @NonNull
    T allOf(AllOfViewMatcher allOfMatcher);

}
