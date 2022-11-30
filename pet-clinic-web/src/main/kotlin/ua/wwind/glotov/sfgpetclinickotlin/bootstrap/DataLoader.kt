package ua.wwind.glotov.sfgpetclinickotlin.bootstrap

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.model.Vet
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService
import ua.wwind.glotov.sfgpetclinickotlin.services.VetSevice
import ua.wwind.glotov.sfgpetclinickotlin.services.map.OwnerMapService
import ua.wwind.glotov.sfgpetclinickotlin.services.map.VetMapService

@Component
class DataLoader: CommandLineRunner {

    private val ownerService: OwnerService = OwnerMapService()
    private val vetService: VetSevice = VetMapService()

    override fun run(vararg args: String?) {
        Owner()
            .apply {
                id = 1L
                firstName = "Michael"
                lastName = "Weston"
            }.also { ownerService.save(it) }
        Owner()
            .apply {
                id = 2L
                firstName = "Fiona"
                lastName = "Glenanne"
            }.also { ownerService.save(it) }
        println("Loaded owners")

        Vet()
            .apply {
                id = 1L
                firstName = "Sam"
                lastName = "Axe"
            }.also {
                vetService.save(it)
            }
        Vet()
            .apply {
                id = 2L
                firstName = "John"
                lastName = "Silver"
            }.also {
                vetService.save(it)
            }
        println("Loaded vets")
    }
}