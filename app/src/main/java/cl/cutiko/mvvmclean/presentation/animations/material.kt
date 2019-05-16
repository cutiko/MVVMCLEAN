package cl.cutiko.mvvmclean.presentation.animations

import android.animation.Animator
import android.view.View

private const val SOLID : Float = 1F
private const val TRANSPARENT : Float = 0F
private const val DURATION : Long = 200L

fun crossFade(show : View, hide : View) {
    show.alpha = TRANSPARENT
    show.visibility = View.VISIBLE
    show.animate().setDuration(DURATION).alpha(SOLID).start()
    hide.alpha = SOLID
    hide.visibility = View.VISIBLE
    hide.animate().setDuration(DURATION).alpha(TRANSPARENT).setListener(object : SimplifiedListener {
        override fun onAnimationEnd(animation: Animator?) {
            hide.visibility = View.GONE
        }
    }).start()
}

private interface SimplifiedListener : Animator.AnimatorListener {
    override fun onAnimationRepeat(animation: Animator?) {}
    override fun onAnimationCancel(animation: Animator?) {}
    override fun onAnimationStart(animation: Animator?) {}
}