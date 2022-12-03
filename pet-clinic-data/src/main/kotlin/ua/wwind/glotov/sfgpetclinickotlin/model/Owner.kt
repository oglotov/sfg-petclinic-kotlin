package ua.wwind.glotov.sfgpetclinickotlin.model

class Owner(
    var address: String = "",
    var city: String = "",
    var telephone: String = "",
    val pets: MutableSet<Pet> = mutableSetOf()
) : Person()