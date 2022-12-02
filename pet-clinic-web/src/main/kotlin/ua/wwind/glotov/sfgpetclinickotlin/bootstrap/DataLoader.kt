package ua.wwind.glotov.sfgpetclinickotlin.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.model.Pet
import ua.wwind.glotov.sfgpetclinickotlin.model.PetType
import ua.wwind.glotov.sfgpetclinickotlin.model.Vet
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService
import ua.wwind.glotov.sfgpetclinickotlin.services.PetTypeService
import ua.wwind.glotov.sfgpetclinickotlin.services.VetSevice
import java.time.LocalDate

@Component
class DataLoader @Autowired constructor(
    val petTypeService: PetTypeService,
    val ownerService: OwnerService,
    val vetService: VetSevice
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        val dog = PetType("Dog").also { petTypeService.save(it) }
        val cat = PetType("Cat").also { petTypeService.save(it) }
        println("Loaded pet types")


        Owner()
            .apply {
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
                            owner = it,
                            birthDate = LocalDate.now()
                        ),
                        Pet(
                            "Sosyska",
                            petType = dog,
                            owner = it,
                            birthDate = LocalDate.now()
                        )
                    )
                )
                ownerService.save(it)
                println(it)
            }
        Owner()
            .apply {
                firstName = "Fiona"
                lastName = "Glenanne"
                address = "123 Brickerel"
                city = "Miami"
                telephone = "321456785"
            }.also {
                it.pets.addAll(
                    setOf(
                        Pet("Tishka", cat, it, LocalDate.now()),
                        Pet("Brovko", dog, it, LocalDate.now())
                    )
                )
                ownerService.save(it)
                println(it)
            }
        println("Loaded owners")

        Vet()
            .apply {
                firstName = "Sam"
                lastName = "Axe"
            }.also {
                vetService.save(it)
            }
        Vet()
            .apply {
                firstName = "John"
                lastName = "Silver"
            }.also {
                vetService.save(it)
            }
        println("Loaded vets")
    }
}