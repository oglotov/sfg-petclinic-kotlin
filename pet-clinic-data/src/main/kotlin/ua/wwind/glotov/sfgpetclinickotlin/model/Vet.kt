package ua.wwind.glotov.sfgpetclinickotlin.model

class Vet : Person() {
    var specialities: MutableSet<Specialty> = mutableSetOf()
}
