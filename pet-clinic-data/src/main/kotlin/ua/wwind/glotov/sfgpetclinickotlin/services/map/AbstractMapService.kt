package ua.wwind.glotov.sfgpetclinickotlin.services.map

abstract class AbstractMapService<T, ID> {
    protected val map: MutableMap<ID?, T> = hashMapOf()
    fun findAll(): Set<T> = HashSet(map.values)
    fun findById(id: ID): T? = map[id]
    fun save(id: ID?, data: T): T = map.put(id, data).let { data }
    fun deleteById(id: ID) {
        map.remove(id)
    }

    fun delete(data: T) {
        map.entries.removeIf { entry -> entry.value?.equals(data) ?: false }
    }
}