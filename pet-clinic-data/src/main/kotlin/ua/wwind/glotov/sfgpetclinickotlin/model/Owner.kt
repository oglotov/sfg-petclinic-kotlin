package ua.wwind.glotov.sfgpetclinickotlin.model

data class Owner(
    var address: String = "",
    var city: String = "",
    var telephone: String = "",
    val pets: MutableSet<Pet> = mutableSetOf()
) : Person() {
    override fun toString(): String {
        return "Owner(id=$id, address='$address', city='$city', telephone='$telephone', pets=${pets.map { it.toStringWithoutOwner() }})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Owner

        if (address != other.address) return false
        if (city != other.city) return false
        if (telephone != other.telephone) return false

        return true
    }

    override fun hashCode(): Int {
        var result = address.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + telephone.hashCode()
        return result
    }

}
