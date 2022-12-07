package ua.wwind.glotov.sfgpetclinickotlin.services.springdatajpa

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import ua.wwind.glotov.sfgpetclinickotlin.repositories.OwnerRepository
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerServiceUtils
import java.util.*

@ExtendWith(MockitoExtension::class)
class OwnerSDJpaServiceTest {

    @Mock
    lateinit var ownerRepository: OwnerRepository
    @InjectMocks
    lateinit var ownerService: OwnerSDJpaService

    @Test
    fun findById() {
        `when`(ownerRepository.findById(anyLong())).thenReturn(Optional.of(OwnerServiceUtils.getOwner()))
        val result = ownerService.findById(1L)
        assertNotNull(result)
        assertEquals(result!!.id, OwnerServiceUtils.getOwner().id)
        assertEquals(result!!.firstName, OwnerServiceUtils.getOwner().firstName)
        verify(ownerRepository).findById(1L)
    }

    @Test
    fun save() {
        val newOwner = OwnerServiceUtils.getNewOwner()
        `when`(ownerRepository.save(any())).thenReturn(newOwner)
        val returned = ownerService.save(newOwner)
        assertEquals(returned, newOwner)
        verify(ownerRepository).save(newOwner)
    }

    @Test
    fun findAll() {
        val ownerList = mutableListOf(OwnerServiceUtils.getOwner())
        `when`(ownerRepository.findAll()).thenReturn(ownerList)
        val returned = ownerService.findAll()
        assertEquals(returned.size, 1)
        verify(ownerRepository, times(1)).findAll()
    }

    @Test
    fun delete() {
        doNothing().`when`(ownerRepository).delete(any())
        ownerService.delete(OwnerServiceUtils.getOwner())
        verify(ownerRepository, times(1)).delete(OwnerServiceUtils.getOwner())
    }

    @Test
    fun deleteById() {
        doNothing().`when`(ownerRepository).deleteById(anyLong())
        ownerService.deleteById(1L)
        verify(ownerRepository, times(1)).deleteById(1L)
    }

    @Test
    fun findByLastName() {
        `when`(ownerRepository.findByLastName(anyString())).thenReturn(OwnerServiceUtils.getOwner())
        val owner = ownerService.findByLastName("Smith")
        assertNotNull(owner)
        verify(ownerRepository, times(1)).findByLastName("Smith")
    }
}