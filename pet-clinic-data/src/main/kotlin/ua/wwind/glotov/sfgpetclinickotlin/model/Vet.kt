package ua.wwind.glotov.sfgpetclinickotlin.model

class Vet : Person() {
    val specialities: MutableSet<Specialty> = mutableSetOf()
}
