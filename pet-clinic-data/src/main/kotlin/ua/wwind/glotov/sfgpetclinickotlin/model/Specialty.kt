package ua.wwind.glotov.sfgpetclinickotlin.model

data class Specialty(
    var description: String? = null
) : BaseEntity() {
    override fun toString(): String {
        return "Specialty(id=$id, description=$description)"
    }
}