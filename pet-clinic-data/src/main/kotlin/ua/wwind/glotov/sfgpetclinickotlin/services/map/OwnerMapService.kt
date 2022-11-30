package ua.wwind.glotov.sfgpetclinickotlin.services.map

import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService

class OwnerMapService: AbstractMapService<Owner, Long>(), OwnerService {
    override fun findByLastName(lastName: String): Owner {
        TODO("Not yet implemented")
    }

    override fun save(data: Owner): Owner = super.save(data.id, data)
}