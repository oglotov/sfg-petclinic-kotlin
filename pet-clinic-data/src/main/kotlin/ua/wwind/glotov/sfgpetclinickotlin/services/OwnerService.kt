package ua.wwind.glotov.sfgpetclinickotlin.services

import ua.wwind.glotov.sfgpetclinickotlin.model.Owner

interface OwnerService {
    fun findByLastName(lastName: String): Owner
    fun findById(id: Long): Owner
    fun save(owner: Owner): Owner
    fun findAll(): Set<Owner>
}