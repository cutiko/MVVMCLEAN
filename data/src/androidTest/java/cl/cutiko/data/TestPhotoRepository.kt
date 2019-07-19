package cl.cutiko.data

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import cl.cutiko.data.repository.PhotosRepository
import cl.cutiko.data.source.firebase.PhotosRtdDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestPhotoRepository {

    private val dataSource = PhotosRtdDataSource()
    private val photosRepository = PhotosRepository(dataSource)

    @Test
    fun testGetPhotos() {
        val context = InstrumentationRegistry.getInstrumentation().context
        dataSource.initializeFirebase(context)
        val photos = runBlocking { photosRepository.getPhotos() }
        assertNotEquals(0, photos?.size)
    }

}