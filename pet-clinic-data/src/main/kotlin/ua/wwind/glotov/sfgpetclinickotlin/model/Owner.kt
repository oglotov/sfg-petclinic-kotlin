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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Owner

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (address != other.address) return false
        if (city != other.city) return false
        if (telephone != other.telephone) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + telephone.hashCode()
        return result
    }

}