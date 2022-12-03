package ua.wwind.glotov.sfgpetclinickotlin.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "pets")
class Pet(
    @Column(name = "name")
    var name: String = "",
    @ManyToOne
    @JoinColumn(name = "type_id")
    var petType: PetType? = null,
    @Column(name = "birth_date")
    var birthDate: LocalDate? = null
) : BaseEntity() {
    @ManyToOne
    @JoinColumn(name = "owner_id")
    var owner: Owner? = null
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "pet")
    val visits: MutableSet<Visit> = mutableSetOf()
}