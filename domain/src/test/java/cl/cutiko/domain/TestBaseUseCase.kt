package cl.cutiko.domain

import cl.cutiko.domain.usecases.BaseUseCase
import cl.cutiko.domain.usecases.LiveResult
import cl.cutiko.domain.usecases.LiveState
import junit.framework.TestCase.assertTrue
import junit.framework.TestCase.fail
import org.junit.Test

class TestBaseUseCase {

    private val liveResult = LiveResult<Boolean>()
    private val baseUseCase = object : BaseUseCase<Boolean>() {
        override suspend fun doWork() = true
    }

    @Test
    fun testSuccess() {
        val baseUseCase = object : BaseUseCase<Boolean>() {
            override suspend fun doWork() = true
        }
        baseUseCase.backgroundWork(liveResult)
        when (liveResult.value) {
            is LiveState.Loading -> fail("Result was loading, should be true")
            is LiveState.OnError -> fail("Result was error should be true")
            is LiveState.OnSuccess -> {
                val result = (liveResult.value as LiveState.OnSuccess<Boolean>).result
                assertTrue(result)
            }
        }
    }

    @Test
    fun testLoading() {

        baseUseCase.backgroundWork(liveResult)
        when (liveResult.value) {
            is LiveState.Loading -> fail("Result was loading, should be true")
            is LiveState.OnError -> fail("Result was error should be true")
            is LiveState.OnSuccess -> {
                val result = (liveResult.value as LiveState.OnSuccess<Boolean>).result
                assertTrue(result)
            }
        }
    }

    @Test
    fun testError() {
        val baseUseCase = object : BaseUseCase<Boolean>() {
            override suspend fun doWork() = true
        }
        baseUseCase.backgroundWork(liveResult)
        when (liveResult.value) {
            is LiveState.Loading -> fail("Result was loading, should be true")
            is LiveState.OnError -> fail("Result was error should be true")
            is LiveState.OnSuccess -> {
                val result = (liveResult.value as LiveState.OnSuccess<Boolean>).result
                assertTrue(result)
            }
        }
    }


}