package ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa

import mu.KotlinLogging
import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.repositories.OwnerRepository
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService
import kotlin.jvm.optionals.getOrNull

class OwnerSDJpaService(
    private val ownerRepository: OwnerRepository,
) : OwnerService {

    private val log = KotlinLogging.logger {  }
    @OptIn(ExperimentalStdlibApi::class)
    override fun findById(id: Long): Owner? = ownerRepository.findById(id).getOrNull()

    override fun save(data: Owner): Owner {
        log.debug { "Saving owner with name ${data.firstName}" }
        return ownerRepository.save(data)
    }

    override fun findAll(): Set<Owner> = ownerRepository.findAll().toSet()

    override fun delete(data: Owner) = ownerRepository.delete(data)

    override fun deleteById(id: Long) = ownerRepository.deleteById(id)

    override fun findByLastName(lastName: String): List<Owner> = ownerRepository.findByLastNameContainsIgnoreCase(lastName)
}