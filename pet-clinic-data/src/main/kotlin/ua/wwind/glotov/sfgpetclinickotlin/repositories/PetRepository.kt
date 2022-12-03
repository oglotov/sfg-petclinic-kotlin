package ua.wwind.glotov.sfgpetclinickotlin.repositories

import org.springframework.data.repository.ListCrudRepository
import ua.wwind.glotov.sfgpetclinickotlin.model.Pet

interface PetRepository : ListCrudRepository<Pet, Long>