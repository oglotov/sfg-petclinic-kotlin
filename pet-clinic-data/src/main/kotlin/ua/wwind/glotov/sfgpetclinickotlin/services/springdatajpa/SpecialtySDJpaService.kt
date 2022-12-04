package ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa

import ua.wwind.glotov.sfgpetclinickotlin.model.Specialty
import ua.wwind.glotov.sfgpetclinickotlin.repositories.SpecialtyRepository
import ua.wwind.glotov.sfgpetclinickotlin.services.SpecialtyService
import kotlin.jvm.optionals.getOrNull

class SpecialtySDJpaService(private val specialtyRepository: SpecialtyRepository) : SpecialtyService {
    @OptIn(ExperimentalStdlibApi::class)
    override fun findById(id: Long): Specialty? = specialtyRepository.findById(id).getOrNull()

    override fun save(data: Specialty): Specialty = specialtyRepository.save(data)

    override fun findAll(): Set<Specialty> = specialtyRepository.findAll().toSet()

    override fun delete(data: Specialty) = specialtyRepository.delete(data)

    override fun deleteById(id: Long) = specialtyRepository.deleteById(id)
}