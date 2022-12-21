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
    @Profile("default,map")
    fun ownerService(petTypeService: PetTypeService, petService: PetService): OwnerService =
        OwnerMapService(petTypeService, petService)

    @Bean
    @Profile("default,map")
    fun vetService(specialtyService: SpecialtyService): VetService = VetMapService(specialtyService)

    @Bean
    @Profile("default,map")
    fun petTypeService(): PetTypeService = PetTypeMapService()

    @Bean
    @Profile("default,map")
    fun petService(petTypeService: PetTypeService): PetService = PetMapService(petTypeService)

    @Bean
    @Profile("default,map")
    fun specialtyService(): SpecialtyService = SpecialtyMapService()

    @Bean
    @Profile("default,map")
    fun visitService(): VisitService = VisitMapService()

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

    @Bean
    @Profile("springdatajpa")
    fun visitSDJpaService(visitRepository: VisitRepository): VisitService =
        VisitSDJpaService(visitRepository)
}