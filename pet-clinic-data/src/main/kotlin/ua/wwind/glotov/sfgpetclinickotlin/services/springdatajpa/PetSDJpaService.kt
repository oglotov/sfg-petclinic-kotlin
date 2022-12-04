package ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa

import ua.wwind.glotov.sfgpetclinickotlin.model.Pet
import ua.wwind.glotov.sfgpetclinickotlin.repositories.PetRepository
import ua.wwind.glotov.sfgpetclinickotlin.services.PetService
import kotlin.jvm.optionals.getOrNull

class PetSDJpaService(private val petRepository: PetRepository) : PetService {
    @OptIn(ExperimentalStdlibApi::class)
    override fun findById(id: Long): Pet? = petRepository.findById(id).getOrNull()

    override fun save(data: Pet): Pet = petRepository.save(data)

    override fun findAll(): Set<Pet> = petRepository.findAll().toSet()

    override fun delete(data: Pet) = petRepository.delete(data)

    override fun deleteById(id: Long) = petRepository.deleteById(id)
}