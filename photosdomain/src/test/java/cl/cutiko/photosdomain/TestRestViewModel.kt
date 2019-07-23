package cl.cutiko.photosdomain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import cl.cutiko.domain.usecases.LiveState
import cl.cutiko.models.Photo
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
    private val viewModel = PhotosRestViewModel()
    private lateinit var state: Any

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun testLoading() {
        state = LiveState.Loading<List<Photo>?>()
        viewModel.mutablePhotos.postValue(state as LiveState.Loading<List<Photo>?>)
        test("loading")
    }

    @Test
    fun testError() {
        state = LiveState.OnError<List<Photo>?>()
        viewModel.mutablePhotos.postValue(state as LiveState.OnError<List<Photo>?>)
        test("error")
    }

    @Test
    fun testSuccess() {
        state = LiveState.OnSuccess<List<Photo>?>(emptyList())
        viewModel.mutablePhotos.postValue(state as LiveState.OnSuccess<List<Photo>?>)
        test("success")
    }

    private fun test(message: String) {
        val value = viewModel.livePhotos.value
        if (value != null) {
            val actual = value::class.java.simpleName
            val expected = state::class.java.simpleName
            if (actual != expected) {
                fail("The expected live data was $message but got $expected")
            }
            println("Test passed value was $expected")
        } else {
            fail("The live data value was null")
        }
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }


}