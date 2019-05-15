package cl.cutiko.mvvmclean.domain.usecases

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

abstract class BaseUseCase<Result, LiveResult : MutableLiveData<LiveState<Result>>> {

    private val superVisorJob = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + superVisorJob)

    protected abstract suspend fun doWork() : Result

    fun backgroundWork(liveResult: LiveResult) = scope.launch {
        liveResult.value = LiveState.Loading()
        runCatching {
            withContext(Dispatchers.IO) {doWork() }
        }.onSuccess { result -> liveResult.postValue(LiveState.OnSuccess(result))
        }.onFailure { liveResult.postValue(LiveState.OnError()) }
    }

    fun cancelWork() = scope.coroutineContext.cancelChildren()

}