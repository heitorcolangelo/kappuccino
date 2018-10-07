package com.heitorcolangelo.kappuccino.core

import android.support.annotation.VisibleForTesting
import android.support.test.espresso.ViewAction
import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.ViewInteraction
import android.view.View
import org.hamcrest.Matcher

/**
 * This is the library's core processor, it will:
 *
 * 1 - [List] of [ViewMatcherMethods] (List<ViewMatcherMethods>) into [List] of [Matcher] of [View] (List<Matcher<View>>),
 * using [ViewMatcherMethodConverter].
 *
 * 2 - List<Matcher<View>> into [List] of [ViewInteraction] (List<ViewInteraction>)
 *
 */
class KappuccinoCoreProcessor(
        viewMatcherMethods: List<ViewMatcherMethod>,
        private val converter: ViewMatcherMethodConverter,
        private val processor: ViewInteractionProcessor
) {

    private val viewInteractions: List<ViewInteraction>

    @VisibleForTesting
    val viewMatchers: List<Matcher<View>> = viewMatcherMethods.map {
        converter.toViewMatcher(it)
    }

    init {
        // Get one view interaction for each Matcher<View>
        viewInteractions = viewMatchers.map {
            processor.viewInteractionFor(it)
        }
    }

    /**
     * Check the passed [ViewAssertion] for every [ViewInteraction] in [KappuccinoCoreProcessor.viewInteractions]
     */
    fun check(assertion: ViewAssertion) {
        for (interaction in viewInteractions) interaction.check(assertion)
    }

    /**
     * Perform the passed [ViewAction] for every [ViewInteraction] in [KappuccinoCoreProcessor.viewInteractions]
     */
    fun perform(action: ViewAction) {
        for (interaction in viewInteractions) interaction.perform(action)
    }

}