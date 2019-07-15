package cl.cutiko.data

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import cl.cutiko.data.source.firebase.PhotosRtdDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestPhotosRtd {

    private val photoRtd = PhotosRtdDataSource()

    @Test
    fun testGetPhotos() {
        initializeFirebase()
        val photos = runBlocking { photoRtd.getPhotos() }
        assertNotEquals(0, photos?.size)
    }

}