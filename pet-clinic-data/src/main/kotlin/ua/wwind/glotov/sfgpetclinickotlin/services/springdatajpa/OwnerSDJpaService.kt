package ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa

import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.repositories.OwnerRepository
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService
import kotlin.jvm.optionals.getOrNull

class OwnerSDJpaService constructor(
    private val ownerRepository: OwnerRepository,
//    private val petTypeService: PetTypeService,
//    private val petService: PetService
    ) : OwnerService {
    @OptIn(ExperimentalStdlibApi::class)
    override fun findById(id: Long): Owner? = ownerRepository.findById(id).getOrNull()

    override fun save(data: Owner): Owner {
        return ownerRepository.save(data)
    }

    override fun findAll(): Set<Owner> = ownerRepository.findAll().toSet()

    override fun delete(data: Owner) = ownerRepository.delete(data)

    override fun deleteById(id: Long) = ownerRepository.deleteById(id)

    override fun findByLastName(lastName: String): Owner? = ownerRepository.findByLastName(lastName)
}