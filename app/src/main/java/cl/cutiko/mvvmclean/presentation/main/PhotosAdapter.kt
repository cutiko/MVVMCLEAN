package cl.cutiko.mvvmclean.presentation.main;

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.cutiko.mvvmclean.R
import cl.cutiko.mvvmclean.data.models.Photo
import com.squareup.picasso.Picasso

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotoHolder>() {

    private val photos = arrayListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_photo, parent, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val photo = photos[position]
        holder.setView(photo)
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

        private val imageView  = itemView.findViewById<ImageView>(R.id.photoIv)
        private val textView = itemView.findViewById<TextView>(R.id.descriptionTv)

        fun setView(photo: Photo) {
            Picasso.get().load(photo.urls?.regular).centerCrop().fit().into(imageView)
            textView.text = photo.safeDesciption
            textView.setBackgroundColor(Color.parseColor(photo.color))
        }

    }

}
