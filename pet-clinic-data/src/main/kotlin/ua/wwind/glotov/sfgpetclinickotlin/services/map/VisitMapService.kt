package ua.wwind.glotov.sfgpetclinickotlin.services.map

import ua.wwind.glotov.sfgpetclinickotlin.model.Visit
import ua.wwind.glotov.sfgpetclinickotlin.services.VisitService

class VisitMapService : AbstractMapService<Visit>(), VisitService {
    override fun save(data: Visit): Visit {
        if (data.pet == null) throw RuntimeException("Invalid visit")
        return super.save(data)
    }
}