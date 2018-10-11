package com.heitorcolangelo.kappuccino.core;

import android.support.annotation.NonNull;
import android.support.test.espresso.ViewAssertion;
import android.view.View;

import org.hamcrest.Matcher;

import javax.annotation.ParametersAreNonnullByDefault;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

@SuppressWarnings("WeakerAccess")
@ParametersAreNonnullByDefault
public class VisibilityAssertion extends BaseAssertionProvider {

    VisibilityAssertion() {
    }

    @Override
    @NonNull Matcher<View> getViewMatcher() {
        return isDisplayed();
    }

    public static Displayed displayed() {
        return new Displayed(new VisibilityAssertion());
    }

    public static NotDisplayed notDisplayed() {
        return new NotDisplayed(new VisibilityAssertion());
    }

    public static class Displayed extends BaseViewAssertion<Displayed> {

        private final VisibilityAssertion visibilityAssertion;

        Displayed(VisibilityAssertion visibilityAssertion) {
            this.visibilityAssertion = visibilityAssertion;
        }

        @Override
        @NonNull ViewAssertion getViewAssertion() {
            return visibilityAssertion.getViewAssertion(true);
        }

        @Override
        @NonNull Displayed getInstance() {
            return this;
        }

    }

    public static class NotDisplayed extends BaseViewAssertion<NotDisplayed> {

        private final VisibilityAssertion assertion;

        NotDisplayed(VisibilityAssertion assertion) {
            this.assertion = assertion;
        }

        @Override
        @NonNull ViewAssertion getViewAssertion() {
            return assertion.getViewAssertion(false);
        }

        @Override
        @NonNull NotDisplayed getInstance() {
            return this;
        }

    }

}