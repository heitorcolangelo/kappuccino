package com.heitorcolangelo.kappuccino.java.assertion;

import com.heitorcolangelo.kappuccino.core.ViewMatcherMethod;
import com.heitorcolangelo.kappuccino.core.assertion.BaseVisibilityAssertion;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class VisibilityAssertion extends BaseVisibilityAssertion {

    private VisibilityAssertion(ViewMatcherMethod... viewMatcherMethods) {
        super(viewMatcherMethods);
    }

    public static void displayed(ViewMatcherMethod... viewMatchers) {
        VisibilityAssertion assertion = new VisibilityAssertion(viewMatchers);
        assertion.setAssertion(true);
        assertion.doAssert();
    }

    public static void notDisplayed(ViewMatcherMethod... viewMatchers) {
        VisibilityAssertion assertion = new VisibilityAssertion(viewMatchers);
        assertion.setAssertion(false);
        assertion.doAssert();
    }

}