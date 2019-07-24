package cl.cutiko.photoslist.main


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cl.cutiko.domain.usecases.LiveState
import cl.cutiko.models.Photo
import cl.cutiko.photosdomain.viewmodels.PhotosViewModel
import cl.cutiko.photoslist.R
import cl.cutiko.presentation.animations.crossFade
import kotlinx.android.synthetic.main.fragment_photos_list.*


class PhotosListFragment : Fragment(), Observer<LiveState<List<Photo>?>> {

    private val adapter = PhotosAdapter()

    companion object {
        @JvmStatic
        fun newInstance() = PhotosListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photosRv.layoutManager = LinearLayoutManager(requireContext())
        photosRv.setHasFixedSize(true)
        photosRv.adapter = adapter
    }

    @CallSuper
    open fun setViewModel(photosViewModel: PhotosViewModel) {
        photosViewModel.livePhotos.observe(this, this)
        photosViewModel.getPhotos()
    }

    @CallSuper
    override fun onChanged(state: LiveState<List<Photo>?>?) {
        when(state) {
            is LiveState.Loading -> Log.d("CUTIKO_TAG", "PhotosListFragment: -----LOADING-----")
            is LiveState.OnError -> Log.d("CUTIKO_TAG", "PhotosListFragment: ******ERROR******")
            is LiveState.OnSuccess -> {
                //This throw thread exception for testing
                adapter.update(state.result)
                crossFade(photosRv, photosPb)
            }
        }
    }

}
