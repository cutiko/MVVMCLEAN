package cl.cutiko.data

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import cl.cutiko.data.source.firebase.PhotosRtdDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestPhotosRtd {

    private val photosRtd = PhotosRtdDataSource()

    @Test
    fun testGetPhotos() {
        val context = InstrumentationRegistry.getInstrumentation().context
        photosRtd.initializeFirebase(context)
        val photos = runBlocking { photosRtd.getPhotos() }
        assertNotEquals(0, photos?.size)
    }

}