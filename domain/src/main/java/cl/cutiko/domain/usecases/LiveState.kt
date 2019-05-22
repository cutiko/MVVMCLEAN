package cl.cutiko.domain.usecases

import androidx.lifecycle.MutableLiveData

typealias LiveResult<Result> = MutableLiveData<LiveState<Result>>

sealed class LiveState<Result> {

    data class OnSuccess<Result>(val result : Result) : LiveState<Result>()
    class OnError<Result> : LiveState<Result>()
    class Loading<Result> : LiveState<Result>()


}