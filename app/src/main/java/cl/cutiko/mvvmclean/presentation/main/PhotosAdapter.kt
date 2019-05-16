package cl.cutiko.mvvmclean.presentation.main;

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.cutiko.mvvmclean.R
import cl.cutiko.mvvmclean.data.models.Photo
import cl.cutiko.mvvmclean.presentation.views.LazyImageView

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotoHolder>() {

    private val photos = arrayListOf<Photo>()
    private lateinit var fallbackText : String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_photo, parent, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val photo = photos[position]
        if (!::fallbackText.isInitialized) fallbackText = holder.itemView.context.getString(R.string.no_description)
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


    inner class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val lazyIv  = itemView.findViewById<LazyImageView>(R.id.lazyIv)
        private val textView = itemView.findViewById<TextView>(R.id.descriptionTv)

        fun setView(photo: Photo, fallbackText : String) {
            lazyIv.setImage(photo.urls?.regular)
            textView.text = photo.safeDescription(fallbackText)
            textView.setBackgroundColor(Color.parseColor(photo.color))
        }

    }

    fun Photo.safeDescription(fallbackText: String) = when {
        alt_description != null -> alt_description
        description != null -> description
        else -> fallbackText
    }

}
