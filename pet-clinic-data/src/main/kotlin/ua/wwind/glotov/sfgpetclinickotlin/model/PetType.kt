package ua.wwind.glotov.sfgpetclinickotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "pet_types")
class PetType (
    @Column(name = "name")
    var name: String
) : BaseEntity() {
    @Override
    override fun toString(): String {
        return name
    }

}