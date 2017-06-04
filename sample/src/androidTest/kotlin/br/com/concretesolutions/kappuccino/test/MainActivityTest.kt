package br.com.concretesolutions.kappuccino.test

import android.content.Intent
import android.support.test.espresso.intent.Intents
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import br.com.concretesolutions.kappuccino.MainActivity
import br.com.concretesolutions.kappuccino.R
import br.com.concretesolutions.kappuccino.actions.TextActions.typeText
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.notDisplayed
import br.com.concretesolutions.kappuccino.custom.intent.IntentMatcherInteractions.matchIntent
import br.com.concretesolutions.kappuccino.custom.recyclerView.RecyclerViewInteractions.recyclerView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    var mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Test
    fun displayed_checkView() {
        intentMatcherTest()
        displayed {
            text(R.string.hello_world)
            id(R.id.text_hello_world)
        }
    }

    @Test
    fun notDisplayed_checkView() {
        intentMatcherTest()
        notDisplayed {
            id(R.id.text_hello_world_invisible)
        }
    }

    @Test
    fun displayed_scrollTo_checkView() {
        intentMatcherTest()
        displayed {
            text(R.string.hello_world)
            id(R.id.text_hello_world)
            allOf {
                id(R.id.text_hello_world2)
                text(R.string.hello_world_2)
            }
        }
    }

    @Test
    fun displayed_allOf_checkView() {
        intentMatcherTest()
        displayed {
            allOf {
                id(R.id.text_hello_world2)
                text(R.string.hello_world_2)
            }
        }
    }

    @Test
    fun displayed_allOf_scrollTo_checkView() {
        intentMatcherTest()
        displayed {
            allOf {
                id(R.id.text_hello_world2)
                text(R.string.hello_world_2)
            }
        }
    }

    @Test
    fun displayed_image_checkView() {
        intentMatcherTest()
        displayed {
            image(R.mipmap.ic_launcher)
        }
    }

    @Test
    fun typeText_edit_text() {
        intentMatcherTest()
        typeText("HAHAHA") {
            allOf {
                id(R.id.edit_hello_world)
                parent {
                    id(R.id.main_parent)
                }
            }
        }
    }

    @Test
    fun checkParentFunction() {
        intentMatcherTest()
        displayed {
            parent(R.id.main_parent) {
                id(R.id.text_hello_world)
                id(R.id.text_hello_world2)
            }
        }
    }

    @Test
    fun kapp_displayed_test() {
        intentMatcherTest()
        displayed {
            id(R.id.text_hello_world)
            allOf {
                id(R.id.text_hello_world)
                text(R.string.hello_world)
            }
            id(R.id.text_hello_world2)
        }
    }

    @Test
    fun recyclerView_test() {
        intentMatcherTest()
        recyclerView(R.id.recyclerview1) {
            atPosition(1) {
                displayed {
                    text("PHP")
                }
            }
        }
    }

    @Test
    fun intentMatcherTest() {
        Intents.init()
        matchIntent {
            action(Intent.ACTION_VIEW)
            url("https://play.google.com/store/apps/details?id=br.com.carrefour.cartaocarrefour")
            resultOk()
        }

        mActivityRule.launchActivity(Intent())

        matchIntent {
            action(Intent.ACTION_VIEW)
            url("https://play.google.com/store/apps/details?id=br.com.carrefour.cartaocarrefour")
        }

        Intents.release()
    }

}