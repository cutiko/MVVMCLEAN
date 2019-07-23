package cl.cutiko.photosdomain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import cl.cutiko.domain.usecases.LiveState
import cl.cutiko.photosdomain.viewmodels.PhotosRestViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class TestRestViewModel {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun testLoading() {
        val viewModel = PhotosRestViewModel()
        viewModel.mutablePhotos.postValue(LiveState.Loading())
        val value = viewModel.livePhotos.value
        if (value !is LiveState.Loading) {
            fail("LiveData should be loading but it wasn't: ${value.toString()}")
        }
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }


}