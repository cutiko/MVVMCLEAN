package cl.cutiko.mvvmclean.domain.usecases

sealed class LiveState<Result> {

    data class OnSuccess<Result>(val result : Result) : LiveState<Result>()
    class OnError<Result> : LiveState<Result>()
    class Loading<Result> : LiveState<Result>()


}