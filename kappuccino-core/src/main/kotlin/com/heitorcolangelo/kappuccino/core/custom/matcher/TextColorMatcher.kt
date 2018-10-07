package com.heitorcolangelo.kappuccino.core.custom.matcher

import android.content.Context
import android.support.annotation.ColorRes
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView
import org.hamcrest.Description

class TextColorMatcher(@ColorRes private val colorId: Int) : BoundedMatcher<View, TextView>(TextView::class.java) {

    val context: Context = InstrumentationRegistry.getTargetContext()
    private val expectedColor = ContextCompat.getColor(context, colorId)
    private var currentColor = 0


    override fun describeTo(description: Description) {
        description.appendText("expected TextColor: ")
                .appendValue(Integer.toHexString(expectedColor))
        description.appendText(" current TextColor: ")
                .appendValue(Integer.toHexString(currentColor))
    }

    override fun matchesSafely(item: TextView): Boolean {
        if (currentColor == 0) currentColor = item.currentTextColor
        return currentColor == expectedColor
    }

}