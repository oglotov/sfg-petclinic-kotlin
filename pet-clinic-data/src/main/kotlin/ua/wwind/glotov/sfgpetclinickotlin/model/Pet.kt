package ua.wwind.glotov.sfgpetclinickotlin.model

import java.time.LocalDate

data class Pet(
    var name: String = "",
    var petType: PetType? = null,
    var owner: Owner? = null,
    var birthDate: LocalDate? = null
) : BaseEntity() {
    fun toStringWithoutOwner(): String {
        return "Pet(id=$id, name=$name, petType=$petType, birthDate=$birthDate)"
    }
}