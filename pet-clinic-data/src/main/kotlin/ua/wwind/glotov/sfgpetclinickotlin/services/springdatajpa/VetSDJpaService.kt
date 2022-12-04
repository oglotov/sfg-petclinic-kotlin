package ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa

import ua.wwind.glotov.sfgpetclinickotlin.model.Vet
import ua.wwind.glotov.sfgpetclinickotlin.repositories.VetRepository
import ua.wwind.glotov.sfgpetclinickotlin.services.VetService
import kotlin.jvm.optionals.getOrNull

class VetSDJpaService(private val vetRepository: VetRepository) : VetService {
    @OptIn(ExperimentalStdlibApi::class)
    override fun findById(id: Long): Vet? = vetRepository.findById(id).getOrNull()

    override fun save(data: Vet): Vet = vetRepository.save(data)

    override fun findAll(): Set<Vet> = vetRepository.findAll().toSet()

    override fun delete(data: Vet) = vetRepository.delete(data)

    override fun deleteById(id: Long) = vetRepository.deleteById(id)
}