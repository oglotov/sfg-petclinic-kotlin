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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pet

        if (id != other.id) return false
        if (name != other.name) return false
        if (petType != other.petType) return false
        if (birthDate != other.birthDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + (petType?.hashCode() ?: 0)
        result = 31 * result + (birthDate?.hashCode() ?: 0)
        return result
    }

}