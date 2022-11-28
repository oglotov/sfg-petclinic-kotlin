package ua.wwind.glotov.sfgpetclinickotlin.services.map

import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.services.CrudService

class OwnerMapService: AbstractMapService<Owner, Long>(), CrudService<Owner, Long> {
    override fun save(data: Owner): Owner = super.save(data.id, data)
}