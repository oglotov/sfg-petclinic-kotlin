package ua.wwind.glotov.sfgpetclinickotlin.services

interface CrudService<T, ID> {
    fun findById(id: ID): T?
    fun save(data: T): T
    fun findAll(): Set<T>
    fun delete(data: T)
    fun deleteById(id: ID)
}