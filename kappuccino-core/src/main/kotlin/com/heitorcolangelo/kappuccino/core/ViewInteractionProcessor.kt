package com.heitorcolangelo.kappuccino.core

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.view.View
import org.hamcrest.Matcher

object ViewInteractionProcessor {

    fun viewInteractionFor(viewMatcher: Matcher<View>): ViewInteraction {
        return onView(viewMatcher)
    }

}