package ua.wwind.glotov.sfgpetclinickotlin.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.io.Serializable

@MappedSuperclass
open class BaseEntity : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    val isNew: Boolean
        get() = id == null
}