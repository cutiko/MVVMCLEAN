package cl.cutiko.data

import cl.cutiko.data.repository.PhotosRepository
import cl.cutiko.data.source.rest.PhotosRestDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Test

class TestPhotosRepository {

    private val photosRepository = PhotosRepository(PhotosRestDataSource())

    @Test
    fun testGetPhotos() {
        val photos = runBlocking { photosRepository.getPhotos() }
        assertNotEquals(0, photos)
    }

}