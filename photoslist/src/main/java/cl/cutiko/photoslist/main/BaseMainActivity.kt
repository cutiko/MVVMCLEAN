package cl.cutiko.photoslist.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import cl.cutiko.photosdomain.viewmodels.PhotosRestViewModel
import cl.cutiko.photosdomain.viewmodels.PhotosRtdViewModel
import cl.cutiko.photoslist.R
import cl.cutiko.presentation.animations.crossFade
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseMainActivity : AppCompatActivity(),  BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav.setOnNavigationItemSelectedListener(this)
        val restViewModel = ViewModelProviders.of(this).get(PhotosRestViewModel::class.java)
        val rtdViewModel = ViewModelProviders.of(this).get(PhotosRtdViewModel::class.java)
        val restPhotos = PhotosListFragment.newInstance()
        val rtdPhotos = PhotosListFragment.newInstance()
        val transaction = supportFragmentManager.beginTransaction().disallowAddToBackStack()
        transaction
            .add(R.id.restContainer, restPhotos)
            //.add(R.id.rtdContainer, rtdPhotos)
            .commitNowAllowingStateLoss()
        MainActivity.idlingResource.increment()
        MainActivity.idlingResource.increment()
        restPhotos.setViewModel(restViewModel)
        rtdPhotos.setViewModel(rtdViewModel)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.isChecked) return true
        when (item.itemId) {
            R.id.navigation_rest -> crossFade(restContainer, rtdContainer)
            R.id.navigation_rtd -> crossFade(rtdContainer, restContainer)
        }
        return true
    }

}