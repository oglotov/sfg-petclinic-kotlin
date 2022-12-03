package ua.wwind.glotov.sfgpetclinickotlin.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "specialties")
class Specialty(
    @Column(name = "name")
    var description: String? = null
) : BaseEntity()