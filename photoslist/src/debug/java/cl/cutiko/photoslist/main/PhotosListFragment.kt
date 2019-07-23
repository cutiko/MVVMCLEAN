package cl.cutiko.photoslist.main

import android.util.Log
import androidx.test.espresso.idling.CountingIdlingResource
import cl.cutiko.domain.usecases.LiveState
import cl.cutiko.models.Photo
import cl.cutiko.photosdomain.viewmodels.PhotosViewModel

class PhotosListFragment : BasePhotosListFragment() {

    companion object {

        private const val IDLING_NAME = "cl.cutiko.photoslist.main.PhotosListFragment.IDLING_NAME"

        val idlingResource = CountingIdlingResource(IDLING_NAME)

        @JvmStatic
        fun newInstance() = PhotosListFragment()
    }

    override fun setViewModel(photosViewModel: PhotosViewModel) {
        Log.d("CUTIKO_TAG", "${this::javaClass.get().simpleName}: calling the data")
        super.setViewModel(photosViewModel)
        idlingResource.increment()
    }

    override fun onChanged(state: LiveState<List<Photo>?>?) {
        super.onChanged(state)
        if (state !is LiveState.Loading) {
            //If another decrement is added the counter will be corrupted as expected
            idlingResource.decrement()
            Log.d("CUTIKO_TAG", "DECREMENT")
        }

        if (state != null) {
            Log.d("CUTIKO_TAG", "${this::javaClass.get().simpleName}: onChanged ${state::class.java.simpleName}")
        } else{
            Log.d("CUTIKO_TAG", "${this::javaClass.get().simpleName}: onChanged state is null")
        }
    }
}