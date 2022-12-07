package ua.wwind.glotov.sfgpetclinickotlin.bootstrap

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import ua.wwind.glotov.sfgpetclinickotlin.services.PetTypeService
import ua.wwind.glotov.sfgpetclinickotlin.services.boostrap.DataLoaderService

@Component
class DataLoader @Autowired constructor(
    private val petTypeService: PetTypeService,
    private val dataLoaderService: DataLoaderService,
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        if (petTypeService.findAll().isEmpty()) dataLoaderService.loadData()
    }

}