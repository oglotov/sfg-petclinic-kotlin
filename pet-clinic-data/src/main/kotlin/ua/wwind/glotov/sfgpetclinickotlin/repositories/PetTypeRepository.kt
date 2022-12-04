package ua.wwind.glotov.sfgpetclinickotlin.repositories

import org.springframework.data.repository.ListCrudRepository
import org.springframework.stereotype.Repository
import ua.wwind.glotov.sfgpetclinickotlin.model.PetType

@Repository
interface PetTypeRepository : ListCrudRepository<PetType, Long>