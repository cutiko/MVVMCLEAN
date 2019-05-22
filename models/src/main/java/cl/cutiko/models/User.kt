package cl.cutiko.models

data class User(
    var id : String? = null,
    var username: String? = null,
    var profile_image: ProfileImage? = null
)