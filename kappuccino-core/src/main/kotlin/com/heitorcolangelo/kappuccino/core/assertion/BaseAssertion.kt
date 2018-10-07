package com.heitorcolangelo.kappuccino.core.assertion

import android.support.test.espresso.ViewAssertion
import com.heitorcolangelo.kappuccino.core.KappuccinoCoreProcessor
import com.heitorcolangelo.kappuccino.core.ViewInteractionProcessor
import com.heitorcolangelo.kappuccino.core.ViewMatcherMethod
import com.heitorcolangelo.kappuccino.core.ViewMatcherMethodConverter


/**
 * This interface provide the doAssert method for every assertion class
 * @see [BaseVisibilityAssertion]
 */
abstract class BaseAssertion(protected open val viewMatcherMethods: Array<ViewMatcherMethod>) {

    /**
     * Perform the assertion for each [BaseAssertion.viewMatcherMethods] and based on the ViewAssertion provided by
     * [BaseAssertion.getViewAssertion] method.
     *
     * @see [BaseVisibilityAssertion]
     *
     */
    protected fun doAssert() {
        KappuccinoCoreProcessor(viewMatcherMethods.toList(), ViewMatcherMethodConverter, ViewInteractionProcessor)
                .check(getViewAssertion())
    }

    /**
     * Provide the ViewAssertion to be used in the [BaseAssertion.doAssert] method
     *
     * @see [BaseVisibilityAssertion]
     *
     */
    protected abstract fun getViewAssertion(): ViewAssertion

}