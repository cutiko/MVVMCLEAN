package cl.cutiko.photomodel

data class Photo(
    var id: String? = null,
    var color: String? = null,
    var description: String? = null,
    var alt_description: String? = null,
    var urls: Urls? = null,
    var user: User? = null,
    var views: Long = 0,
    var download: Long = 0
)