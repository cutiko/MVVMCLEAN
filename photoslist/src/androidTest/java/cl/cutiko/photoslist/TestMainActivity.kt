package cl.cutiko.photoslist

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import cl.cutiko.photoslist.main.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestMainActivity {

    @Before
    fun prepare() {
        IdlingRegistry.getInstance().register(MainActivity.idlingResource)
    }

    @Test
    fun test() {
        ActivityTestRule(MainActivity::class.java).launchActivity(Intent())
        onView(withId(R.id.photosRv)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
    }

    @After
    fun cleanUp() {
        IdlingRegistry.getInstance().unregister(MainActivity.idlingResource)
    }

}