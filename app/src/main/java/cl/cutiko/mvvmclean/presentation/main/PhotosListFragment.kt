package cl.cutiko.mvvmclean.presentation.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import cl.cutiko.mvvmclean.R
import kotlinx.android.synthetic.main.fragment_photos_list.*


abstract class PhotosListFragment : Fragment() {

    private val adapter = PhotosAdapter()

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
}
