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

    public VisibilityAssertion() {
    }

    @Override
    @NonNull public Matcher<View> getViewMatcher() {
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

        public Displayed(VisibilityAssertion visibilityAssertion) {
            this.visibilityAssertion = visibilityAssertion;
        }

        @Override
        @NonNull protected ViewAssertion getViewAssertion() {
            return visibilityAssertion.getViewAssertion(true);
        }

        @Override
        @NonNull protected Displayed getInstance() {
            return this;
        }

    }

    public static class NotDisplayed extends BaseViewAssertion<NotDisplayed> {

        private final VisibilityAssertion visibilityAssertion;

        public NotDisplayed(VisibilityAssertion visibilityAssertion) {
            this.visibilityAssertion = visibilityAssertion;
        }

        @Override
        @NonNull protected ViewAssertion getViewAssertion() {
            return visibilityAssertion.getViewAssertion(false);
        }

        @Override
        @NonNull protected NotDisplayed getInstance() {
            return this;
        }

    }

}