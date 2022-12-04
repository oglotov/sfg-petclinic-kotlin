package ua.wwind.glotov.sfgpetclinickotlin.services.map

import ua.wwind.glotov.sfgpetclinickotlin.model.Vet
import ua.wwind.glotov.sfgpetclinickotlin.services.SpecialtyService
import ua.wwind.glotov.sfgpetclinickotlin.services.VetService

class VetMapService(private val specialtyService: SpecialtyService): AbstractMapService<Vet>(), VetService {
    override fun save(data: Vet): Vet {
        data.specialities.forEach {
            if (it.id == null) specialtyService.save(it)
        }
        return super.save(data)
    }
}