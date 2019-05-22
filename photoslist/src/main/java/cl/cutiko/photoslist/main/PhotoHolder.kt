package cl.cutiko.photoslist.main

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import cl.cutiko.models.Photo
import cl.cutiko.photoslist.R
import cl.cutiko.presentation.views.LazyImageView

class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        private const val DEFAULT_PIXELS = 100
    }

    private val lazyIv  = itemView.findViewById<LazyImageView>(R.id.lazyIv)
    private val textView = itemView.findViewById<TextView>(R.id.descriptionTv)

    fun setView(photo: Photo, fallbackText : String) {
        lazyIv.setImage(photo.urls?.regular)
        textView.text = photo.safeDescription(fallbackText)
        val color = Color.parseColor(photo.color)
        textView.backgroundTintList = ColorStateList.valueOf(color)
        val swatch = Palette.Swatch(color, DEFAULT_PIXELS)
        textView.setTextColor(swatch.titleTextColor)
    }

    private fun Photo.safeDescription(fallbackText: String) = when {
        alt_description != null -> alt_description
        description != null -> description
        else -> fallbackText
    }

}