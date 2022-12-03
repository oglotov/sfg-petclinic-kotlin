package ua.wwind.glotov.sfgpetclinickotlin.model

import jakarta.persistence.*

@Entity
@Table(name = "vets")
class Vet : Person() {
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "vets_specialities",
        joinColumns = [JoinColumn(name = "vet_id")],
        inverseJoinColumns = [JoinColumn(name = "spec_id")])
    val specialities: MutableSet<Specialty> = mutableSetOf()
}
