package cl.cutiko.data

import cl.cutiko.data.source.rest.PhotosRestDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Test

class TestPhotosRest {

    private val restDataSource = PhotosRestDataSource()

    @Test
    fun testGetPhotos() {
        val photos = runBlocking {
            restDataSource.getPhotos()
        }
        assertNotEquals(0, photos?.size)
    }

}