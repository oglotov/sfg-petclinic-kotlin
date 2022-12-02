package ua.wwind.glotov.sfgpetclinickotlin.model

data class PetType (var name: String) : BaseEntity() {
    override fun toString(): String {
        return "PetType(id=$id, name='$name')"
    }
}
