package ua.wwind.glotov.sfgpetclinickotlin.services

import ua.wwind.glotov.sfgpetclinickotlin.model.Vet

interface VetSevice {
    fun findById(id: Long): Vet
    fun save(vet: Vet): Vet
    fun findAll(): Set<Vet>
}