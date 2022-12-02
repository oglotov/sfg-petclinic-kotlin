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
    fun ownerService(): OwnerService = OwnerMapService()

    @Bean
    fun petService(): PetService = PetMapService()

    @Bean
    fun vetService(): VetSevice = VetMapService()

    @Bean
    fun petTypeService(): PetTypeService = PetTypeMapService()
}