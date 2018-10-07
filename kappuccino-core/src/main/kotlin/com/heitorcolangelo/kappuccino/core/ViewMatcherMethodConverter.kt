package com.heitorcolangelo.kappuccino.core

import android.view.View
import org.hamcrest.Matcher

object ViewMatcherMethodConverter {

    fun toViewMatcher(viewMatcherMethods: ViewMatcherMethod): Matcher<View> {
        return viewMatcherMethods.viewMatcher
    }

}