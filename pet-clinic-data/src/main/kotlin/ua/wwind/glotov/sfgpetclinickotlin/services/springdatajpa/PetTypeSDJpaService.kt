package ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa

import ua.wwind.glotov.sfgpetclinickotlin.model.PetType
import ua.wwind.glotov.sfgpetclinickotlin.repositories.PetTypeRepository
import ua.wwind.glotov.sfgpetclinickotlin.services.PetTypeService
import kotlin.jvm.optionals.getOrNull

class PetTypeSDJpaService(private val petTypeRepository: PetTypeRepository) : PetTypeService {
    @OptIn(ExperimentalStdlibApi::class)
    override fun findById(id: Long): PetType? = petTypeRepository.findById(id).getOrNull()

    override fun save(data: PetType): PetType = petTypeRepository.save(data)

    override fun findAll(): Set<PetType> = petTypeRepository.findAll().toSet()

    override fun delete(data: PetType) = petTypeRepository.delete(data)

    override fun deleteById(id: Long) = petTypeRepository.deleteById(id)
}