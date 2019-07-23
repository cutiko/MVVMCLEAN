package cl.cutiko.domain.usecases

import android.util.Log
import kotlinx.coroutines.*

abstract class BaseUseCase<Result> {

    private val superVisorJob = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + superVisorJob)

    protected abstract suspend fun doWork() : Result

    fun backgroundWork(liveResult: LiveResult<Result>) = scope.launch {
        Log.d("CUTIKO_TAG", "${this::javaClass.get().simpleName}: background work")
        liveResult.postValue(LiveState.Loading())
        runCatching {
            withContext(Dispatchers.IO) {doWork() }
        }.onSuccess { result -> liveResult.postValue(LiveState.OnSuccess(result))
        }.onFailure { liveResult.postValue(LiveState.OnError()) }
    }

    fun cancelWork() = scope.coroutineContext.cancelChildren()

}