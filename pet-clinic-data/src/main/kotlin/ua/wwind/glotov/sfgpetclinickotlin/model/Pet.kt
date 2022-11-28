package ua.wwind.glotov.sfgpetclinickotlin.model

import java.time.LocalDate

class Pet: BaseEntity() {
    var petType: PetType? = null
    var owner: Owner? = null
    var birthDate: LocalDate? = null
}