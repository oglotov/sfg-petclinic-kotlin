package ua.wwind.glotov.sfgpetclinickotlin.services.map

import ua.wwind.glotov.sfgpetclinickotlin.model.Pet
import ua.wwind.glotov.sfgpetclinickotlin.services.PetService

class PetMapService: AbstractMapService<Pet, Long>(), PetService {
    override fun save(data: Pet): Pet = super.save(data.id, data)
}