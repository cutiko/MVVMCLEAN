package cl.cutiko.photoslist

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.IdlingRegistry
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import cl.cutiko.photoslist.main.PhotosListFragment
import junit.framework.Assert.fail
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestPhotosFragment {

    @Before
    fun prepare() {
        IdlingRegistry.getInstance().register(PhotosListFragment.idlingResource)
    }

    @Test
    fun test() {
        val scenario = launchFragmentInContainer<PhotosListFragment>(factory= Factory())
        fail("this is failing correctly")
    }

    @After
    fun cleanUp() {
        IdlingRegistry.getInstance().unregister(PhotosListFragment.idlingResource)
    }

}

