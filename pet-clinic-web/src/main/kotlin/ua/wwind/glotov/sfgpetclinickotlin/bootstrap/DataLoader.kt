package ua.wwind.glotov.sfgpetclinickotlin.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ua.wwind.glotov.sfgpetclinickotlin.model.*
import ua.wwind.glotov.sfgpetclinickotlin.services.*
import java.time.LocalDate

@Component
class DataLoader @Autowired constructor(
    private val petTypeService: PetTypeService,
    private val ownerService: OwnerService,
    private val vetService: VetService,
    private val specialtyService: SpecialtyService,
    private val visitService: VisitService,
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        if (petTypeService.findAll().isEmpty()) loadData()
    }

    private fun loadData() {
        val petList = mutableListOf<Pet>()
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
                        ).apply { owner = it }
                            .also { pet -> petList.add(pet) },
                        Pet(
                            "Sosyska",
                            petType = dog,
                            birthDate = LocalDate.now()
                        ).apply { owner = it }
                            .also { pet -> petList.add(pet) },
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
                        Pet("Tishka", cat, LocalDate.now()).apply { owner = it }.also { pet -> petList.add(pet) },
                        Pet("Brovko", dog, LocalDate.now()).apply { owner = it }.also { pet -> petList.add(pet) },
                    )
                )
                ownerService.save(it)
                println(it)
            }
        println("Loaded owners")

        val dentistry = Specialty("dentistry").also { specialtyService.save(it) }
        val radiology = Specialty("radiology").also { specialtyService.save(it) }
        val surgery = Specialty("surgery").also { specialtyService.save(it) }

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

        Visit().apply {
            description = "neutered"
            pet = petList[0]
        }.also { visitService.save(it) }
        Visit().apply {
            description = "rabies shot"
            pet = petList.last()
        }.also { visitService.save(it) }
        println("Loaded visits")
    }
}