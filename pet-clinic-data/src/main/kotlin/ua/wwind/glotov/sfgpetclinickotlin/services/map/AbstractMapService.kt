package ua.wwind.glotov.sfgpetclinickotlin.services.map

import ua.wwind.glotov.sfgpetclinickotlin.model.BaseEntity

abstract class AbstractMapService<T: BaseEntity> {
    private val map: MutableMap<Long, T> = hashMapOf()
    fun findAll(): Set<T> = HashSet(map.values)
    fun findById(id: Long): T? = map[id]
    fun save(data: T): T {
        val idToSave = data.id ?: getNextId().also { data.id = it }
        return map.put(idToSave, data).let { data }
    }
    fun deleteById(id: Long) {
        map.remove(id)
    }

    fun delete(data: T) {
        map.entries.removeIf { entry -> (entry.value == data) }
    }

    private fun getNextId(): Long {
        return map.keys.ifEmpty { setOf(0L) }.max() + 1
    }
}