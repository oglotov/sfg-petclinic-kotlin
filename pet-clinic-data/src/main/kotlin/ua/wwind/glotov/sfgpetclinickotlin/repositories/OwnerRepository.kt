package ua.wwind.glotov.sfgpetclinickotlin.repositories

import org.springframework.data.repository.ListCrudRepository
import org.springframework.stereotype.Repository
import ua.wwind.glotov.sfgpetclinickotlin.model.Owner

@Repository
interface OwnerRepository: ListCrudRepository<Owner, Long> {
    fun findByLastName(lastName: String): Owner?
}