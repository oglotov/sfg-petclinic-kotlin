package ua.wwind.glotov.sfgpetclinickotlin.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.model.PetType
import ua.wwind.glotov.sfgpetclinickotlin.model.Vet
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService
import ua.wwind.glotov.sfgpetclinickotlin.services.PetTypeService
import ua.wwind.glotov.sfgpetclinickotlin.services.VetSevice

@Component
class DataLoader @Autowired constructor(
    val petTypeService: PetTypeService,
    val ownerService: OwnerService,
    val vetService: VetSevice
): CommandLineRunner {

    override fun run(vararg args: String?) {

        PetType("Dog").also { petTypeService.save(it) }
        PetType("Cat").also { petTypeService.save(it) }
        println("Loaded pet types")

        Owner()
            .apply {
                firstName = "Michael"
                lastName = "Weston"
            }.also { ownerService.save(it) }
        Owner()
            .apply {
                firstName = "Fiona"
                lastName = "Glenanne"
            }.also { ownerService.save(it) }
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