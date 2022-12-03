package ua.wwind.glotov.sfgpetclinickotlin.model

import jakarta.persistence.*

@Entity
@Table(name = "owners")
class Owner : Person() {
    @Column(name = "address")
    var address: String = ""
    @Column(name = "city")
    var city: String = ""
    @Column(name = "telephone")
    var telephone: String = ""
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "owner")
    val pets: MutableSet<Pet> = mutableSetOf()
}