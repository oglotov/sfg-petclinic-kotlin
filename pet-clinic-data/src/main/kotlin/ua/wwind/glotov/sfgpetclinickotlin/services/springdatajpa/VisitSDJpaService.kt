package ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa

import ua.wwind.glotov.sfgpetclinickotlin.model.Visit
import ua.wwind.glotov.sfgpetclinickotlin.repositories.VisitRepository
import ua.wwind.glotov.sfgpetclinickotlin.services.VisitService
import kotlin.jvm.optionals.getOrNull

class VisitSDJpaService(private val visitRepository: VisitRepository) : VisitService {
    @OptIn(ExperimentalStdlibApi::class)
    override fun findById(id: Long): Visit? = visitRepository.findById(id).getOrNull()

    override fun save(data: Visit): Visit {
        if (data.pet == null) throw RuntimeException("Invalid visit")
        return visitRepository.save(data)
    }

    override fun findAll(): Set<Visit> = visitRepository.findAll().toSet()

    override fun delete(data: Visit) = visitRepository.delete(data)

    override fun deleteById(id: Long) = visitRepository.deleteById(id)
}