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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vet

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        return result
    }
}
