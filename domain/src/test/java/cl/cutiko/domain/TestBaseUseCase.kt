package cl.cutiko.domain

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import cl.cutiko.domain.usecases.BaseUseCase
import cl.cutiko.domain.usecases.LiveResult
import cl.cutiko.domain.usecases.LiveState
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class TestBaseUseCase {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun testSuccess() {
        val baseUseCase = object : BaseUseCase<Boolean>() {
            override suspend fun doWork() = true
        }
        val liveResult = LiveResult<Boolean>()
        runBlocking {
            baseUseCase.backgroundWork(liveResult).join()
        }
        val result = liveResult.value as LiveState.OnSuccess<Boolean>
        assertTrue(result.result)
    }

    @Test
    fun testError() {
        val baseUseCase = object : BaseUseCase<Boolean>() {
            override suspend fun doWork() = throw Exception("This has successfully failed")
        }
        val liveResult = LiveResult<Boolean>()
        runBlocking {
            baseUseCase.backgroundWork(liveResult).join()
        }
        assertTrue(liveResult.value is LiveState.OnError)
    }

    @After
    fun cleanUp() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

}