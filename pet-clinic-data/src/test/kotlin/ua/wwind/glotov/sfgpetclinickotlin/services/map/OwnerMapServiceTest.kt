package ua.wwind.glotov.sfgpetclinickotlin.services.map

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.model.Pet
import ua.wwind.glotov.sfgpetclinickotlin.model.PetType
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerServiceUtils
import java.time.LocalDate

class OwnerMapServiceTest {

    private lateinit var ownerService: OwnerMapService
    private lateinit var owner: Owner

    @BeforeEach
    fun setUp() {
        val petTypeService = PetTypeMapService()
        ownerService = OwnerMapService(petTypeService, PetMapService(petTypeService))
        val dog = PetType("Dog").also { petTypeService.save(it) }
        val cat = PetType("Cat").also { petTypeService.save(it) }
        println("Loaded pet types")

        owner = Owner()
            .apply {
                id = 1L
                firstName = "Michael"
                lastName = "Weston"
                address = "123 Brickerel"
                city = "Miami"
                telephone = "12312312312"
            }.also {
                it.pets.addAll(
                    setOf(
                        Pet(
                            name = "Elza",
                            petType = dog,
                            birthDate = LocalDate.now()
                        ).apply { owner = it },
                        Pet(
                            "Sosyska",
                            petType = dog,
                            birthDate = LocalDate.now()
                        ).apply { owner = it }
                    )
                )
                ownerService.save(it)
            }
    }

    @Test
    fun findAll() {
        val ownerSet = ownerService.findAll()
        assertEquals(ownerSet.size, 1)
        assertEquals(ownerSet.first().firstName, "Michael")
    }

    @Test
    fun findById() {
        val owner = ownerService.findById(1L)
        assertNotNull(owner)
        assertEquals(owner?.id, 1L)
        assertEquals(owner?.firstName, "Michael")
    }

    @Test
    fun deleteById() {
        ownerService.deleteById(1L)
        assertTrue { ownerService.findAll().isEmpty() }
    }

    @Test
    fun delete() {
        ownerService.delete(owner)
        assertTrue { ownerService.findAll().isEmpty() }
    }

    @Test
    fun findByLastName() {
        val foundOwner = ownerService.findByLastName("weston")
        assertNotNull(foundOwner)
        assertEquals(foundOwner!!.id, 1L)
        val wrongSearch = ownerService.findByLastName("Smith")
        assertNull(wrongSearch)
    }

    @Test
    fun saveExistingId() {
        owner.lastName = "Kim"
        ownerService.save(owner)
        val savedOwner = ownerService.findById(1L)
        assertEquals(savedOwner?.lastName, "Kim")
    }

    @Test
    fun saveNewId() {
        val newOwner = OwnerServiceUtils.getNewOwner().also { ownerService.save(it) }
        assertEquals(ownerService.findAll().size, 2)
        assertNotNull(newOwner.id)
        assertEquals(newOwner.id, 2L)
    }
}