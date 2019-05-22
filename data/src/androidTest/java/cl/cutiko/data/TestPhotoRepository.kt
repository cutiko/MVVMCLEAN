package cl.cutiko.data

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import cl.cutiko.data.repository.PhotosRepository
import cl.cutiko.data.source.firebase.PhotosRtdDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestPhotoRepository {

    private val photosRepository = PhotosRepository(PhotosRtdDataSource())

    @Test
    fun testGetPhotos() {
        initializeFirebase()
        val photos = runBlocking { photosRepository.getPhotos() }
        assertNotEquals(0, photos?.size)
    }

}