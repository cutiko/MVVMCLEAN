package cl.cutiko.photosdomain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import cl.cutiko.data.source.rest.PhotosRestDataSource
import cl.cutiko.domain.usecases.LiveResult
import cl.cutiko.domain.usecases.LiveState
import cl.cutiko.models.Photo
import cl.cutiko.photosdomain.usecases.GetPhotosUseCase
import junit.framework.Assert.assertNotSame
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TestPhotosUseCase {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun test() {
        val restSource = PhotosRestDataSource()
        val liveResult = LiveResult<List<Photo>?>()
        runBlocking { GetPhotosUseCase(restSource).backgroundWork(liveResult).join() }
        val result = liveResult.value as LiveState.OnSuccess<List<Photo>?>
        assertNotSame(0, result.result?.size)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

}