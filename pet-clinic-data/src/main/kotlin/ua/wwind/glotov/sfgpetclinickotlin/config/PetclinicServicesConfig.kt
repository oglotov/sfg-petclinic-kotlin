package ua.wwind.glotov.sfgpetclinickotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ua.wwind.glotov.sfgpetclinickotlin.services.*
import ua.wwind.glotov.sfgpetclinickotlin.services.map.*

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

    @Bean
    fun specialtyService(): SpecialtyService = SpecialtyMapService()
}