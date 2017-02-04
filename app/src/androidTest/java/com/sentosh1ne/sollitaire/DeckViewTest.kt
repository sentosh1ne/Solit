package com.sentosh1ne.sollitaire


import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.rule.ActivityTestRule
import com.sentosh1ne.sollitaire.game.view.MainActivity
import org.junit.Rule


/**
 * Created by sentosh1ne on 04.02.2017.
 */
@RunWith(AndroidJUnit4 :: class)
@SmallTest
class DeckViewTest{

    @get:Rule
    public val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity :: class.java)

    @Test
    fun clickDeckUntilEmpty(){
        for (i in 0..23)
        {
            onView(withId(R.id.todraw_deck)).perform(click())
        }
    }

}