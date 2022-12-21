package ua.wwind.glotov.sfgpetclinickotlin.services

import ua.wwind.glotov.sfgpetclinickotlin.model.Owner

interface OwnerService : CrudService<Owner, Long> {
    fun findByLastName(lastName: String): List<Owner>

}