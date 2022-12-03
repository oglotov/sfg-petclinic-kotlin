package ua.wwind.glotov.sfgpetclinickotlin.repositories

import org.springframework.data.repository.ListCrudRepository
import ua.wwind.glotov.sfgpetclinickotlin.model.PetType

interface PetTypeRepository : ListCrudRepository<PetType, Long>