package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.NonNull;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Matcher;

import javax.annotation.ParametersAreNonnullByDefault;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.hamcrest.Matchers.not;

/**
 * This class provides the base implementation of an Assertion class.
 * Check {@link VisibilityAssertion} for an example of how to implement it.
 */
@ParametersAreNonnullByDefault
public abstract class BaseAssertion {

    /**
     * Default behavior to return the correct assertion based on the assertionValue.
     * For example, If you want to check if a view is visible, this method will return:
     * <p>
     * matches(isDisplayed())
     * <p>
     * if you want to check that this view is NOT visible:
     * <p>
     * matches(not(isDisplayed())
     *
     * @param assertionValue Inverts or not the logic of the ViewMatcher
     * @return The ViewAssertion object based on the assertion value
     */
    @NonNull ViewAssertion getViewAssertion(boolean assertionValue) {
        if (assertionValue) {
            return matches(getViewMatcher());
        } else {
            return matches(not(getViewMatcher()));
        }
    }

    /**
     * Return the desired assertion.
     * I haven't called this method as "getViewAssertion" because the object that it
     * returns is a {@link Matcher<View>} and not a {@link ViewAssertion}.
     *
     * For example: If your implementation is to check visibility, this method should return
     * {@link ViewMatchers#isDisplayed()}
     *
     * @return The desired {@link ViewMatchers} method.
     */
    public abstract @NonNull Matcher<View> getViewMatcher();

}