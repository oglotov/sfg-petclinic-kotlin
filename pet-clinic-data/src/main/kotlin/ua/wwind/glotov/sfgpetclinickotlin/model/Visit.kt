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
}