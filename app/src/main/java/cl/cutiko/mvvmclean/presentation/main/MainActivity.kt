package cl.cutiko.mvvmclean.presentation.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import cl.cutiko.mvvmclean.R
import cl.cutiko.mvvmclean.domain.viewmodels.PhotosRestViewModel
import cl.cutiko.mvvmclean.domain.viewmodels.PhotosRtdViewModel
import cl.cutiko.mvvmclean.presentation.animations.crossFade
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),  BottomNavigationView.OnNavigationItemSelectedListener {

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
            .add(R.id.rtdContainer, rtdPhotos)
            .commitNowAllowingStateLoss()
        restPhotos.setViewModel(restViewModel)
        rtdPhotos.setViewModel(rtdViewModel)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                crossFade(restContainer, rtdContainer)
                return true
            }
            R.id.navigation_notifications -> {
                crossFade(rtdContainer, restContainer)
                return true
            }
        }
        return false
    }


}