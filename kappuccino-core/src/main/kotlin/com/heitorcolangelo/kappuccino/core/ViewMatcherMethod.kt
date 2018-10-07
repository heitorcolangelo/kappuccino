package com.heitorcolangelo.kappuccino.core

import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.test.espresso.matcher.ViewMatchers.withContentDescription
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.view.View
import com.heitorcolangelo.kappuccino.core.custom.matcher.TextColorMatcher
import com.heitorcolangelo.kappuccino.core.custom.matcher.drawable.BackgroundMatcher
import com.heitorcolangelo.kappuccino.core.custom.matcher.drawable.ImageViewDrawableMatcher
import org.hamcrest.Matcher

class ViewMatcherMethod(val viewMatcher: Matcher<View>)  {

    companion object : ViewMatcherMethods {

        @JvmStatic
        override fun id(@IdRes viewId: Int): ViewMatcherMethod {
            return ViewMatcherMethod(withId(viewId))
        }

        @JvmStatic
        override fun text(textId: Int): ViewMatcherMethod {
            return ViewMatcherMethod(withText(textId))
        }

        @JvmStatic
        override fun text(text: String): ViewMatcherMethod {
            return ViewMatcherMethod(withText(text))
        }

        @JvmStatic
        override fun text(textMatcher: Matcher<String>): ViewMatcherMethod {
            return ViewMatcherMethod(withText(textMatcher))
        }

        @JvmStatic
        override fun contentDescription(@StringRes contentDescriptionId: Int): ViewMatcherMethod {
            return ViewMatcherMethod(withContentDescription(contentDescriptionId))
        }

        @JvmStatic
        override fun contentDescription(contentDescription: String): ViewMatcherMethod {
            return ViewMatcherMethod(withContentDescription(contentDescription))
        }

        @JvmStatic
        override fun contentDescription(contentDescriptionMatcher: Matcher<CharSequence>): ViewMatcherMethod {
            return ViewMatcherMethod(withContentDescription(contentDescriptionMatcher))
        }

        @JvmStatic
        override fun image(@DrawableRes imageId: Int): ViewMatcherMethod {
            return ViewMatcherMethod(ImageViewDrawableMatcher(imageId))
        }

        @JvmStatic
        override fun background(@IdRes drawableId: Int): ViewMatcherMethod {
            return ViewMatcherMethod(BackgroundMatcher(drawableId))
        }

        @JvmStatic
        override fun textColor(@ColorRes color: Int): ViewMatcherMethod {
            return ViewMatcherMethod(TextColorMatcher(color))
        }

        @JvmStatic
        override fun custom(viewMatcher: Matcher<View>): ViewMatcherMethod {
            return ViewMatcherMethod(viewMatcher)
        }

    }

}