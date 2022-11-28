package ua.wwind.glotov.sfgpetclinickotlin.model

import java.time.LocalDate

class Pet {
    var petType: PetType? = null
    var owner: Owner? = null
    var birthDate: LocalDate? = null
}