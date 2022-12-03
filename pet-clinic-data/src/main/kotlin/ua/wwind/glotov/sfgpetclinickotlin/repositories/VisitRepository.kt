package ua.wwind.glotov.sfgpetclinickotlin.repositories;

import org.springframework.data.repository.ListCrudRepository
import ua.wwind.glotov.sfgpetclinickotlin.model.Visit

interface VisitRepository : ListCrudRepository<Visit, Long>