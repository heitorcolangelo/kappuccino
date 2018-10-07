package com.heitorcolangelo.kappuccino.kotlin

import com.heitorcolangelo.kappuccino.core.ViewMatcherMethod
import com.heitorcolangelo.kappuccino.core.ViewMatcherMethods
import com.heitorcolangelo.kappuccino.core.assertion.BaseVisibilityAssertion

private val viewMatchersList: MutableList<ViewMatcherMethod> = mutableListOf()

fun displayed(viewMatchers: ViewMatcherMethods.() -> ViewMatcherMethod) {
    ViewMatcherMethod.apply { viewMatchersList.add(viewMatchers()) }
    VisibilityAssertion(viewMatchersList, true)
    viewMatchersList.clear()
}

fun notDisplayed(viewMatchers: ViewMatcherMethods.() -> ViewMatcherMethod) {
    ViewMatcherMethod.apply { viewMatchersList.add(viewMatchers()) }
    VisibilityAssertion(viewMatchersList, false)
    viewMatchersList.clear()
}

class VisibilityAssertion(viewMatchers: List<ViewMatcherMethod>, assertion: Boolean)
    : BaseVisibilityAssertion(viewMatchers.toTypedArray()) {
    init {
        setAssertion(assertion)
        doAssert()
    }
}