package ua.wwind.glotov.sfgpetclinickotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import ua.wwind.glotov.sfgpetclinickotlin.repositories.*
import ua.wwind.glotov.sfgpetclinickotlin.services.*
import ua.wwind.glotov.sfgpetclinickotlin.services.map.*
import ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa.*

@Configuration
class PetclinicServicesConfig {

    @Bean
    fun petService(petTypeService: PetTypeService): PetService = PetMapService(petTypeService)

    @Bean
    fun ownerService(petTypeService: PetTypeService, petService: PetService): OwnerService =
        OwnerMapService(petTypeService, petService)

    @Bean
    fun vetService(specialtyService: SpecialtyService): VetService = VetMapService(specialtyService)

    @Bean
    fun petTypeService(): PetTypeService = PetTypeMapService()

    @Bean
    fun specialtyService(): SpecialtyService = SpecialtyMapService()

    @Bean
    @Profile("springdatajpa")
    fun ownerSDJpaService(ownerRepository: OwnerRepository): OwnerService =
        OwnerSDJpaService(ownerRepository)

    @Bean
    @Profile("springdatajpa")
    fun vetSDJpaService(vetRepository: VetRepository): VetService = VetSDJpaService(vetRepository)

    @Bean
    @Profile("springdatajpa")
    fun petTypeSDJpaService(petTypeRepository: PetTypeRepository): PetTypeService =
        PetTypeSDJpaService(petTypeRepository)

    @Bean
    @Profile("springdatajpa")
    fun petSDJpaService(petRepository: PetRepository): PetService = PetSDJpaService(petRepository)

    @Bean
    @Profile("springdatajpa")
    fun specialtySDJpaService(specialtyRepository: SpecialtyRepository): SpecialtyService =
        SpecialtySDJpaService(specialtyRepository)

}