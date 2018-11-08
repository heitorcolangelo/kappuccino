package com.heitorcolangelo.kappuccino.kotlin

import com.heitorcolangelo.kappuccino.core.ViewMatcherMethods
import com.heitorcolangelo.kappuccino.core.VisibilityAssertion

private val visibilityAssertion = VisibilityAssertion()
private val viewMatcherMethods = ViewMatcherMethods()

fun displayed2(matcher: VisibilityAssertion.Displayed.() -> Unit) {
    VisibilityAssertion.Displayed(visibilityAssertion, viewMatcherMethods).apply { matcher() }
}

fun notDisplayed2(matcher: VisibilityAssertion.NotDisplayed.() -> Unit) {
    VisibilityAssertion.NotDisplayed(visibilityAssertion, viewMatcherMethods).apply { matcher() }
}

