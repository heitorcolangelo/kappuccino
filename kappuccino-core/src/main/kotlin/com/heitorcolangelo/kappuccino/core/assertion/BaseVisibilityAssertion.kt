package com.heitorcolangelo.kappuccino.core.assertion

import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import com.heitorcolangelo.kappuccino.core.ViewMatcherMethod
import org.hamcrest.Matchers
import javax.annotation.ParametersAreNonnullByDefault

/**
 * Core implementation for all visibility assertion classes
 */
@ParametersAreNonnullByDefault
abstract class BaseVisibilityAssertion(
        override val viewMatcherMethods: Array<ViewMatcherMethod>
) : BaseAssertion(viewMatcherMethods) {

    private lateinit var visibilityAssertion: ViewAssertion

    override fun getViewAssertion(): ViewAssertion {
        return visibilityAssertion
    }

    /**
     * Use this function to swap between:
     *
     * isDisplayed() and not(isDisplayed()) ViewAssertion
     */
    protected fun setAssertion(checkVisible: Boolean) {
        visibilityAssertion = visibility(checkVisible)
    }

    /**
     * Provides the possible visibility assertions
     *
     * @param checkVisible If true, view should be visible, false otherwise.
     *
     * @return ViewAssertion based on the boolean passed as parameter
     */
    protected fun visibility(checkVisible: Boolean): ViewAssertion {
        return if (checkVisible) matches(isDisplayed())
        else matches(Matchers.not(isDisplayed()))
    }

}