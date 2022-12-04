package ua.wwind.glotov.sfgpetclinickotlin.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ua.wwind.glotov.sfgpetclinickotlin.model.*
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService
import ua.wwind.glotov.sfgpetclinickotlin.services.PetTypeService
import ua.wwind.glotov.sfgpetclinickotlin.services.SpecialtyService
import ua.wwind.glotov.sfgpetclinickotlin.services.VetService
import java.time.LocalDate

@Component
class DataLoader @Autowired constructor(
    private val petTypeService: PetTypeService,
    private val ownerService: OwnerService,
    private val vetService: VetService,
    private val specialtyService: SpecialtyService
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        if (petTypeService.findAll().isEmpty()) loadData()
    }

    private fun loadData() {
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
                            birthDate = LocalDate.now()
                        ).apply { owner = it },
                        Pet(
                            "Sosyska",
                            petType = dog,
                            birthDate = LocalDate.now()
                        ).apply { owner = it }
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
                        Pet("Tishka", cat, LocalDate.now()).apply { owner = it },
                        Pet("Brovko", dog, LocalDate.now()).apply { owner = it }
                    )
                )
                ownerService.save(it)
                println(it)
            }
        println("Loaded owners")

        val dentistry = Specialty("dentistry")
        val radiology = Specialty("radiology")
        val surgery = Specialty("surgery")

        Vet()
            .apply {
                firstName = "Sam"
                lastName = "Axe"
                specialities.add(dentistry)
                specialities.add(surgery)
            }.also {
                vetService.save(it)
                println(it)
            }
        Vet()
            .apply {
                firstName = "John"
                lastName = "Silver"
                specialities.add(radiology)
                specialities.add(surgery)
            }.also {
                vetService.save(it)
                println(it)
            }
        println("Loaded vets")
    }
}