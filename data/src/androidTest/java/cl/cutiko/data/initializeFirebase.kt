package cl.cutiko.data

import androidx.test.platform.app.InstrumentationRegistry
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions

private const val NO_APPS = 0

/**
 * Firebase app has to be initialized manually because this is not the app module
 */
fun initializeFirebase() {
    val context = InstrumentationRegistry.getInstrumentation().context
    when (FirebaseApp.getApps(context).size) {
        NO_APPS -> {
            val builder = FirebaseOptions.Builder()
                .setApiKey(BuildConfig.apiKey)
                .setApplicationId(BuildConfig.applicationId)
                .setDatabaseUrl(BuildConfig.databaseUrl)
                .setProjectId(BuildConfig.projectId)
                .build()
            FirebaseApp.initializeApp(context, builder)
        }
    }
}