package cl.cutiko.mvvmclean.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import cl.cutiko.mvvmclean.R
import cl.cutiko.mvvmclean.presentation.animations.crossFade
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class LazyImageView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs), Callback {

    private val progressBar = ProgressBar(context, null, android.R.attr.progressBarStyle)
    private val imageView = ImageView(context)

    init {
        addView(imageView)
        imageView.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        addView(progressBar)
        val pbLayoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        pbLayoutParams.gravity = Gravity.CENTER
        progressBar.layoutParams = pbLayoutParams
    }

    fun setImage(url : String?) = Picasso.get().load(url).centerCrop().fit().into(imageView, this)

    override fun onSuccess() = crossFade(imageView, progressBar)

    override fun onError(e: Exception?) {
        imageView.setImageResource(R.drawable.ic_error_gray_120dp)
        crossFade(imageView, progressBar)
    }

}