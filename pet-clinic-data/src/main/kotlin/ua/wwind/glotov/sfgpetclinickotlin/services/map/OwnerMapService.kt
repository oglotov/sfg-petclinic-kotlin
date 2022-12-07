package ua.wwind.glotov.sfgpetclinickotlin.services.map

import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService
import ua.wwind.glotov.sfgpetclinickotlin.services.PetService
import ua.wwind.glotov.sfgpetclinickotlin.services.PetTypeService

class OwnerMapService(
    private val petTypeService: PetTypeService,
    private val petService: PetService,
    ) : AbstractMapService<Owner>(),
    OwnerService {
    override fun findByLastName(lastName: String): Owner? =
        map.filter { it.value.lastName.equals(lastName, true) }.firstNotNullOfOrNull { it.value }

    override fun save(data: Owner): Owner {
        data.pets.forEach {
            if (it.petType != null) {
                if (it.petType!!.id == null) petTypeService.save(it.petType!!)
            } else throw RuntimeException("Required Pet Type")
            if (it.id == null)
                petService.save(it)
        }
        return super.save(data)
    }
}