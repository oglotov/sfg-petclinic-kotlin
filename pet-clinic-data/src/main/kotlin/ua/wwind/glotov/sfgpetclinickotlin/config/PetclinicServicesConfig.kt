package ua.wwind.glotov.sfgpetclinickotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService
import ua.wwind.glotov.sfgpetclinickotlin.services.PetService
import ua.wwind.glotov.sfgpetclinickotlin.services.PetTypeService
import ua.wwind.glotov.sfgpetclinickotlin.services.VetSevice
import ua.wwind.glotov.sfgpetclinickotlin.services.map.OwnerMapService
import ua.wwind.glotov.sfgpetclinickotlin.services.map.PetMapService
import ua.wwind.glotov.sfgpetclinickotlin.services.map.PetTypeMapService
import ua.wwind.glotov.sfgpetclinickotlin.services.map.VetMapService

@Configuration
class PetclinicServicesConfig {

    @Bean
    fun petService(petTypeService: PetTypeService): PetService = PetMapService(petTypeService)

    @Bean
    fun ownerService(petTypeService: PetTypeService, petService: PetService): OwnerService =
        OwnerMapService(petTypeService, petService)

    @Bean
    fun vetService(): VetSevice = VetMapService()

    @Bean
    fun petTypeService(): PetTypeService = PetTypeMapService()
}