package cl.cutiko.photoslist

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import cl.cutiko.photoslist.main.PhotosListFragment
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestPhotosFragment {

    /*@get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun prepare() {
        Dispatchers.setMain(mainThreadSurrogate)
        IdlingRegistry.getInstance().register(PhotosListFragment.idlingResource)
    }*/

    @Test
    fun test() {
        //This won't work using the theme ¿?
        /*launchFragmentInContainer<PhotosListFragment>(*//*themeResId = R.style.AppTheme,*//* factory = Factory()).run {
            onFragment {
                onView(withId(R.id.photosPb)).check(matches(isDisplayed()))
                *//*it.setViewModel(PhotosRestViewModel())
                onView(withId(R.id.photosRv)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))*//*
            }
        }*/
        with(launchFragmentInContainer<PhotosListFragment>()) {
            onFragment {
                fragment-> assertEquals(null, fragment.arguments)
                onView(withId(R.id.photosPb)).check(matches(isDisplayed()))
            }
        }
    }



    /*@After
    fun cleanUp() {
        IdlingRegistry.getInstance().unregister(PhotosListFragment.idlingResource)
        Dispatchers.resetMain()
    }*/

}

