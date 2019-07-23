package cl.cutiko.photoslist.main

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
        idlingResource.increment()
        super.setViewModel(photosViewModel)
    }

    override fun onChanged(state: LiveState<List<Photo>?>?) {
        super.onChanged(state)
        idlingResource.decrement()
    }
}