package cl.cutiko.photoslist

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import cl.cutiko.photoslist.main.PhotosListFragment

class Factory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment = when(className) {
        PhotosListFragment::class.java.name -> PhotosListFragment.newInstance()
        else -> super.instantiate(classLoader, className)
    }
}