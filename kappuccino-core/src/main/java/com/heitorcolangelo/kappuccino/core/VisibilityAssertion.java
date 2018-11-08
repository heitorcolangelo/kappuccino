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
        return new Displayed(new VisibilityAssertion(), new ViewMatcherMethods());
    }

    public static NotDisplayed notDisplayed() {
        return new NotDisplayed(new VisibilityAssertion(), new ViewMatcherMethods());
    }

    public static class Displayed extends BaseViewAssertion<Displayed> {

        private final VisibilityAssertion visibilityAssertion;
        private final ViewMatcherMethods viewMatcherMethods;

        public Displayed(VisibilityAssertion visibilityAssertion, ViewMatcherMethods viewMatcherMethods) {
            this.visibilityAssertion = visibilityAssertion;
            this.viewMatcherMethods = viewMatcherMethods;
        }

        @Override
        protected @NonNull ViewAssertion getViewAssertion() {
            return visibilityAssertion.getViewAssertion(true);
        }

        @Override
        protected @NonNull Displayed getInstance() {
            return this;
        }

        @Override
        protected @NonNull ViewMatcherMethods viewMatcherMethodsInstance() {
            return viewMatcherMethods;
        }
    }

    public static class NotDisplayed extends BaseViewAssertion<NotDisplayed> {

        private final VisibilityAssertion visibilityAssertion;
        private final ViewMatcherMethods viewMatcherMethods;

        public NotDisplayed(VisibilityAssertion visibilityAssertion, ViewMatcherMethods viewMatcherMethods) {
            this.visibilityAssertion = visibilityAssertion;
            this.viewMatcherMethods = viewMatcherMethods;
        }

        @Override
        protected @NonNull ViewAssertion getViewAssertion() {
            return visibilityAssertion.getViewAssertion(false);
        }

        @Override
        protected @NonNull NotDisplayed getInstance() {
            return this;
        }

        @Override
        protected @NonNull ViewMatcherMethods viewMatcherMethodsInstance() {
            return viewMatcherMethods;
        }
    }

}