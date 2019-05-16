package cl.cutiko.mvvmclean.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import cl.cutiko.mvvmclean.R
import cl.cutiko.mvvmclean.data.models.Photo
import cl.cutiko.mvvmclean.domain.usecases.LiveState
import cl.cutiko.mvvmclean.domain.viewmodels.PhotosRestViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),  BottomNavigationView.OnNavigationItemSelectedListener, Observer<LiveState<List<Photo>?>> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav.setOnNavigationItemSelectedListener(this)
        val viewModel = ViewModelProviders.of(this).get(PhotosRestViewModel::class.java)
        viewModel.livePhotos.observe(this, this)
        viewModel.getPhotos()
    }

    override fun onChanged(state: LiveState<List<Photo>?>?) {
        when (state) {
            is LiveState.Loading -> Log.d("CUTIKO_TAG", "LOADING");
            is LiveState.OnError -> Log.d("CUTIKO_TAG", "ERROR");
            is LiveState.OnSuccess -> state.result?.map {it -> Log.d("CUTIKO_TAG", it.safeDesciption); }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                messageView.setText(R.string.title_home)
                return true
            }
            R.id.navigation_notifications -> {
                messageView.setText(R.string.title_notifications)
                return true
            }
        }
        return false
    }


}