package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.NonNull;
import android.support.test.espresso.ViewAssertion;
import android.view.View;

import org.hamcrest.Matcher;

import javax.annotation.ParametersAreNonnullByDefault;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

@ParametersAreNonnullByDefault
public class VisibilityAssertion extends BaseAssertionProvider {

    VisibilityAssertion() {
    }

    @Override
    @NonNull Matcher<View> getViewMatcher() {
        return isDisplayed();
    }

    public static Displayed displayed() {
        return new Displayed();
    }

    public static NotDisplayed notDisplayed() {
        return new NotDisplayed();
    }

    public static class Displayed extends BaseViewAssertion<Displayed> {

        @Override
        @NonNull ViewAssertion getViewAssertion() {
            return new VisibilityAssertion().getViewAssertion(true);
        }

        @Override
        @NonNull Displayed getInstance() {
            return this;
        }

    }

    public static class NotDisplayed extends BaseViewAssertion<NotDisplayed> {

        @Override
        @NonNull ViewAssertion getViewAssertion() {
            return new VisibilityAssertion().getViewAssertion(false);
        }

        @Override
        @NonNull NotDisplayed getInstance() {
            return this;
        }

    }

}
