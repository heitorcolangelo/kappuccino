package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;
import android.widget.ImageView;

import com.heitorcolangelo.kappuccino.core.custom.matcher.TextColorMatcher;
import com.heitorcolangelo.kappuccino.core.custom.matcher.drawable.BackgroundMatcher;
import com.heitorcolangelo.kappuccino.core.custom.matcher.drawable.ImageViewDrawableMatcher;

import org.hamcrest.Matcher;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface ViewMatcherMethods {

    /**
     * Match view based on view Id.
     * <p>
     * It will call {@link ViewMatchers#withId(int)}
     */
    @NotNull
    ViewMatcherMethod id(@IdRes int viewId);

    /**
     * Match a view based on {@link StringRes} text.
     * <p>
     * It will call {@link ViewMatchers#withText(int)}
     */
    @NotNull
    ViewMatcherMethod text(@StringRes int textId);

    /**
     * Match a view based on custom {@link String}text.
     * <p>
     * It will call {@link ViewMatchers#withText(String)}
     */
    @NotNull
    ViewMatcherMethod text(String text);

    /**
     * Match a view based on {@link Matcher<String>} content description.
     * <p>
     * It will call {@link ViewMatchers#withText(Matcher)}
     */
    @NotNull
    ViewMatcherMethod text(Matcher<String> textMatcher);

    /**
     * Match a view based on {@link StringRes} content description.
     * <p>
     * It will call {@link ViewMatchers#withContentDescription(int)}
     */
    @NotNull
    ViewMatcherMethod contentDescription(@StringRes int contentDescriptionId);

    /**
     * Match a view based on {@link String} content description.
     * <p>
     * It will call {@link ViewMatchers#withContentDescription(String)}
     */
    @NotNull
    ViewMatcherMethod contentDescription(String contentDescription);

    /**
     * Match a view based on {@link Matcher<CharSequence>} content description.
     * <p>
     * It will call {@link ViewMatchers#withContentDescription(Matcher)}
     */
    @NotNull
    ViewMatcherMethod contentDescription(Matcher<CharSequence> contentDescriptionMatcher);

    /**
     * Match a view based on {@link DrawableRes} image Id of a {@link ImageView}.
     * <p>
     * It will call {@link ImageViewDrawableMatcher} constructor
     */
    @NotNull
    ViewMatcherMethod image(@DrawableRes int drawableId);

    /**
     * Match a view based on {@link IdRes} background drawable Id.
     * <p>
     * It will call {@link BackgroundMatcher} constructor
     */
    @NotNull
    ViewMatcherMethod background(@IdRes int backgroundId);

    /**
     * Match a view based on {@link ColorRes} text color value.
     * <p>
     * It will call {@link TextColorMatcher} constructor
     */
    @NotNull
    ViewMatcherMethod textColor(@ColorRes int color);

    /**
     * Match a view based on the custom matcher passed as parameter
     */
    @NotNull
    ViewMatcherMethod custom(Matcher<View> viewMatcher);

}
