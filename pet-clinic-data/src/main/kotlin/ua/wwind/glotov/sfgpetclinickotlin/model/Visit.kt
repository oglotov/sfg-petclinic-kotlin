package ua.wwind.glotov.sfgpetclinickotlin.model

import jakarta.persistence.*
import org.hibernate.Hibernate
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
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Visit

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , date = $date , description = $description , petId = ${pet?.id} )"
    }

}