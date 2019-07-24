package cl.cutiko.photoslist.main

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.test.espresso.idling.CountingIdlingResource
import cl.cutiko.domain.usecases.LiveState
import cl.cutiko.models.Photo
import cl.cutiko.photosdomain.viewmodels.PhotosRestViewModel
import cl.cutiko.photosdomain.viewmodels.PhotosRtdViewModel

class MainActivity : BaseMainActivity(), Observer<LiveState<List<Photo>?>> {

    companion object {
        private const val IDLING_NAME = "cl.cutiko.photoslist.main.MainActivity.IDLING_NAME"
        @JvmStatic
        val idlingResource = CountingIdlingResource(IDLING_NAME, true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val restViewModel = ViewModelProviders.of(this).get(PhotosRestViewModel::class.java)
        val rtdViewModel = ViewModelProviders.of(this).get(PhotosRtdViewModel::class.java)
        restViewModel.livePhotos.observe(this, this)
        rtdViewModel.livePhotos.observe(this, this)
    }

    override fun onChanged(state: LiveState<List<Photo>?>?) {
        when (state) {
            is LiveState.OnSuccess -> idlingResource.decrement()
            is LiveState.OnError -> idlingResource.decrement()
            is LiveState.Loading -> Log.d("CUTIKO_TAG", "${this::javaClass.get().simpleName}: loading")
        }
    }



}