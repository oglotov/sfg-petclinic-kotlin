package ua.wwind.glotov.sfgpetclinickotlin.services

import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.model.Pet
import ua.wwind.glotov.sfgpetclinickotlin.model.PetType
import java.time.LocalDate

object OwnerServiceUtils {

    private var owner1: Owner? = null

    private fun initOwner() {
        val dog = PetType("Dog")
        val cat = PetType("Cat")
        owner1 = Owner()
            .apply {
                id = 1L
                firstName = "Michael"
                lastName = "Weston"
                address = "123 Brickerel"
                city = "Miami"
                telephone = "12312312312"
            }.also {
                it.pets.addAll(
                    setOf(
                        Pet(
                            name = "Elza",
                            petType = dog,
                            birthDate = LocalDate.now()
                        ).apply { owner = it },
                        Pet(
                            "Sosyska",
                            petType = dog,
                            birthDate = LocalDate.now()
                        ).apply { owner = it }
                    )
                )
            }
    }

    fun getOwner(): Owner {
        if (owner1 == null) initOwner()
        return owner1!!
    }

    fun getNewOwner(): Owner {
        return Owner().apply {
            id = null
            firstName = "Peter"
            lastName = "Smith"
        }
    }

}