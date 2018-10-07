package com.heitorcolangelo.kappuccino.kotlin.sample

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.heitorcolangelo.kappuccino.kotlin.displayed
import com.heitorcolangelo.kappuccino.kotlin.notDisplayed
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VisibilityAssertionActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule<VisibilityAssertionActivity>(VisibilityAssertionActivity::class.java, false, true)

    @Test
    fun baseVisibilityTest() {
        displayed {
            id(R.id.visible_text_view)
            text(R.string.txt_visible)
        }

        notDisplayed {
            id(R.id.not_visible_text_view)
            text(R.string.txt_gone)
        }
    }
}