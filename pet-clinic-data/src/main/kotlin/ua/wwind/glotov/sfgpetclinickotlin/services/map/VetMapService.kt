package ua.wwind.glotov.sfgpetclinickotlin.services.map

import ua.wwind.glotov.sfgpetclinickotlin.model.Vet
import ua.wwind.glotov.sfgpetclinickotlin.services.VetSevice

class VetMapService: AbstractMapService<Vet, Long>(), VetSevice {
    override fun save(data: Vet): Vet = super.save(data.id, data)
}