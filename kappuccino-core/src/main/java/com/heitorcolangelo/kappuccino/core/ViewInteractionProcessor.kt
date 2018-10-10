package com.heitorcolangelo.kappuccino.core

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewAction
import android.support.test.espresso.ViewAssertion
import android.view.View
import org.hamcrest.Matcher

class ViewInteractionProcessor(private val viewMatcher: Matcher<View>) {

    /**
     * Check the passed [ViewAssertion] for the [ViewInteractionProcessor.viewMatcher]
     */
    fun check(assertion: ViewAssertion) {
        onView(viewMatcher).check(assertion)
    }

    /**
     * Perform the passed [ViewAction] for the [ViewInteractionProcessor.viewMatcher]
     */
    fun perform(action: ViewAction) {
        onView(viewMatcher).perform(action)
    }

}