package ua.wwind.glotov.sfgpetclinickotlin.model

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
open class Person(
    @Column(name = "first_name")
    var firstName: String = "",
    @Column(name = "last_name")
    var lastName: String = ""
) : BaseEntity()