package ua.wwind.glotov.sfgpetclinickotlin.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "visits")
class Visit : BaseEntity() {
    @Column(name = "date")
    var date: LocalDate = LocalDate.now()
    @Column(name = "description")
    var description: String? = null
    @ManyToOne
    @JoinColumn(name = "pet_id")
    var pet: Pet? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Visit

        if (id != other.id) return false
        if (date != other.date) return false
        if (description != other.description) return false
        if (pet != other.pet) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (pet?.hashCode() ?: 0)
        return result
    }
}