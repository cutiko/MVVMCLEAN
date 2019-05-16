package cl.cutiko.mvvmclean.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import cl.cutiko.mvvmclean.R
import cl.cutiko.mvvmclean.domain.viewmodels.PhotosRestViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),  BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav.setOnNavigationItemSelectedListener(this)
        val viewModel = ViewModelProviders.of(this).get(PhotosRestViewModel::class.java)
        val restPhotos = PhotosListFragment()
        val transaction = supportFragmentManager.beginTransaction().disallowAddToBackStack()
        transaction.add(R.id.restContainer, restPhotos).commitNowAllowingStateLoss()
        restPhotos.setViewModel(viewModel)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                Log.d("CUTIKO_TAG", "${this::javaClass.get().simpleName}: home")
                return true
            }
            R.id.navigation_notifications -> {
                Log.d("CUTIKO_TAG", "${this::javaClass.get().simpleName}: notifications")
                return true
            }
        }
        return false
    }


}