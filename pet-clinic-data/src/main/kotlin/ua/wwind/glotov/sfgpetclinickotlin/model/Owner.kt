package ua.wwind.glotov.sfgpetclinickotlin.model

class Owner : Person() {
    private val pets: MutableSet<Pet> = mutableSetOf()
}
