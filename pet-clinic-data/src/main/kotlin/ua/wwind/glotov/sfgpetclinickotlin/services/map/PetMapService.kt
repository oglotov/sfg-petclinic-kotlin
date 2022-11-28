package ua.wwind.glotov.sfgpetclinickotlin.services.map

import ua.wwind.glotov.sfgpetclinickotlin.model.Pet
import ua.wwind.glotov.sfgpetclinickotlin.services.CrudService

class PetMapService: AbstractMapService<Pet, Long>(), CrudService<Pet, Long> {
    override fun save(data: Pet): Pet = super.save(data.id, data)
}