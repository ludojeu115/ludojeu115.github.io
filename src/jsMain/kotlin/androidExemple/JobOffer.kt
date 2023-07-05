package androidExemple

data class JobOffer(
    val id: Long = 0L,
    var employerId: Long = 0L,
    val title: String = "",
    val description: String = "",
    val location: String = "",
    var startDate: String = "",
    var endDate: String? = null
)

data class SharedOffer(
    val id: Long = 0L,
    var jobOfferId: Long = 0L,
    var sharingGroupId: Long = 0L
)

data class SharingGroupMember(
    val id: Long = 0L,
    var memberId: Long = 0L,
    var sharingGroupId: Long = 0L
)

data class SharingGroup(
    val id: Long = 0L,
    val name: String = "",
    var userId: Long = 0L
)

data class Application(
    val id: Long = 0L,
    var jobOfferId: Long = 0L,
    var jobSeekerId: Long = 0L,
    val status: String = "en_attente"
)

data class User(
    val id: Long = 0L,
    val birthdate: String = "",
    val email: String = "",
    val city: String = "",
    val nationality: String = "",
    val password: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var phoneNumber: String = "",
    var registrationType: String = ""
)