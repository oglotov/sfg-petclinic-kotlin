package ua.wwind.glotov.sfgpetclinickotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import ua.wwind.glotov.sfgpetclinickotlin.repositories.OwnerRepository
import ua.wwind.glotov.sfgpetclinickotlin.repositories.PetRepository
import ua.wwind.glotov.sfgpetclinickotlin.repositories.PetTypeRepository
import ua.wwind.glotov.sfgpetclinickotlin.repositories.VetRepository
import ua.wwind.glotov.sfgpetclinickotlin.services.*
import ua.wwind.glotov.sfgpetclinickotlin.services.map.*
import ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa.OwnerSDJpaService
import ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa.PetSDJpaService
import ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa.PetTypeSDJpaService
import ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa.VetSDJpaService

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
    fun petTypeSDJpaService(petTypeRepository: PetTypeRepository): PetTypeService = PetTypeSDJpaService(petTypeRepository)

    @Bean
    @Profile("springdatajpa")
    fun petSDJpaService(petRepository: PetRepository): PetService = PetSDJpaService(petRepository)

}