package cl.cutiko.photosdomain

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import cl.cutiko.data.source.firebase.PhotosRtdDataSource
import cl.cutiko.domain.usecases.LiveResult
import cl.cutiko.domain.usecases.LiveState
import cl.cutiko.models.Photo
import cl.cutiko.photosdomain.usecases.GetPhotosUseCase
import junit.framework.Assert.assertNotSame
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class TestPhotoUseCase {

    @Test
    fun test() {
        val rtdSource = PhotosRtdDataSource()
        val liveResult = LiveResult<List<Photo>?>()
        rtdSource.initializeFirebase(InstrumentationRegistry.getInstrumentation().context)
        runBlocking { GetPhotosUseCase(rtdSource).backgroundWork(liveResult).join() }
        val result = liveResult.value as LiveState.OnSuccess<List<Photo>?>
        assertNotSame(0, result.result?.size)
    }

}