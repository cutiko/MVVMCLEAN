package cl.cutiko.photoslist.main;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.cutiko.photomodel.Photo
import cl.cutiko.photoslist.R

class PhotosAdapter : RecyclerView.Adapter<PhotoHolder>() {

    private val photos = arrayListOf<Photo>()
    private lateinit var fallbackText : String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        if (!::fallbackText.isInitialized) fallbackText = parent.context.getString(R.string.no_description)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_photo, parent, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val photo = photos[position]
        holder.setView(photo, fallbackText)
    }

    override fun getItemCount(): Int = photos.size

    fun update(photos : List<Photo>?) = photos?.let{
        this.photos.addAll(it)
        notifyDataSetChanged()
        return@let true
    } ?: run {
        return false
    }

}
