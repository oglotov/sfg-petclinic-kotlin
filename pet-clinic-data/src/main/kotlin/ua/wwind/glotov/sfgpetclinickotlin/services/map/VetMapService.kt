package ua.wwind.glotov.sfgpetclinickotlin.services.map

import ua.wwind.glotov.sfgpetclinickotlin.model.Vet
import ua.wwind.glotov.sfgpetclinickotlin.services.CrudService

class VetMapService: AbstractMapService<Vet, Long>(), CrudService<Vet, Long> {
    override fun save(data: Vet): Vet = super.save(data.id, data)
}