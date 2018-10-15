package com.heitorcolangelo.kappuccino.kotlin

import com.heitorcolangelo.kappuccino.core.VisibilityAssertion

object VisibilityAssertionKt : VisibilityAssertion() {

    fun displayed2(matcher: VisibilityAssertion.Displayed.() -> VisibilityAssertion.Displayed) {
        VisibilityAssertion.Displayed(this).apply { matcher() }
    }

    fun notDisplayed2(matcher: VisibilityAssertion.NotDisplayed.() -> VisibilityAssertion.NotDisplayed) {
        VisibilityAssertion.NotDisplayed(this).apply { matcher() }
    }

}

