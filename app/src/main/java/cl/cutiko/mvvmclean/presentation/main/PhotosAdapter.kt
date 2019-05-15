package cl.cutiko.mvvmclean.presentation.main;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.cutiko.mvvmclean.R
import cl.cutiko.mvvmclean.data.models.Photo

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotoHolder>() {

    private val photos = arrayListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_photo, parent, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val photo = photos[position]
    }

    override fun getItemCount(): Int = photos.size


    inner class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {

        }

    }

}
