package cl.cutiko.photoslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import cl.cutiko.photosdomain.viewmodels.PhotosRestViewModel
import cl.cutiko.photoslist.main.PhotosListFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestPhotosFragment {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun prepare() {
        Dispatchers.setMain(mainThreadSurrogate)
        IdlingRegistry.getInstance().register(PhotosListFragment.idlingResource)
    }

    @Test
    fun test() {
        //This won't work using the theme ¿?
        launchFragmentInContainer<PhotosListFragment>(/*themeResId = R.style.AppTheme,*/ factory = Factory()).run {
            onFragment {
                it.setViewModel(PhotosRestViewModel())
                onView(withId(R.id.photosRv)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
                fail("this has failed correctly")
            }
        }
    }

    @After
    fun cleanUp() {
        IdlingRegistry.getInstance().unregister(PhotosListFragment.idlingResource)
        Dispatchers.resetMain()
    }

}

