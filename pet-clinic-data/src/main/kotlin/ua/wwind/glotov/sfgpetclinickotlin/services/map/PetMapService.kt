package ua.wwind.glotov.sfgpetclinickotlin.services.map

import ua.wwind.glotov.sfgpetclinickotlin.model.Pet
import ua.wwind.glotov.sfgpetclinickotlin.services.PetService
import ua.wwind.glotov.sfgpetclinickotlin.services.PetTypeService

class PetMapService constructor(private val petTypeService: PetTypeService) : AbstractMapService<Pet>(), PetService {
    override fun save(data: Pet): Pet {
        if (data.petType != null) {
            if (data.petType!!.id == null) petTypeService.save(data.petType!!)
        } else throw RuntimeException("Required Pet Type")

        return super.save(data)
    }
}