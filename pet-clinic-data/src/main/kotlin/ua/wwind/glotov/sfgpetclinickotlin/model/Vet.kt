package ua.wwind.glotov.sfgpetclinickotlin.model

data class Vet(
    val specialities: MutableSet<Specialty> = mutableSetOf()
) : Person() {
    override fun toString(): String {
        return "Vet(id=$id, firstName=$firstName, lastName=$lastName, specialities=$specialities)"
    }
}
