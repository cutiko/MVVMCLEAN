package cl.cutiko.photoslist

import android.content.Intent
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import cl.cutiko.photoslist.main.MainActivity
import cl.cutiko.photoslist.main.PhotosListFragment
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestPhotoFragment2 {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)
    //private val mainThreadSurrogate = newSingleThreadContext("UI thread")


    @Before
    fun prepare() {
        //Dispatchers.setMain(mainThreadSurrogate)
        IdlingRegistry.getInstance().register(PhotosListFragment.idlingResource)
    }

    @Test
    fun test() {
        activityRule.launchActivity(Intent())
        //onView(withId(R.id.photosPb)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //val fragmentManager = activityRule.activity.supportFragmentManager
        onView(withId(R.id.photosRv)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
    }

    @After
    fun cleanUp() {
        IdlingRegistry.getInstance().unregister(PhotosListFragment.idlingResource)
        //Dispatchers.resetMain()
    }

}