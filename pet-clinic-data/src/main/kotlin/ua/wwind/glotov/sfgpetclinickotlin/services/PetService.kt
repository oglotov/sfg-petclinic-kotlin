package ua.wwind.glotov.sfgpetclinickotlin.services

import ua.wwind.glotov.sfgpetclinickotlin.model.Pet

interface PetService {
    fun findById(id: Long): Pet
    fun save(pet: Pet): Pet
    fun findAll(): Set<Pet>
}