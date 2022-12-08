package ua.wwind.glotov.sfgpetclinickotlin.controllers

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view
import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService

@WebMvcTest(controllers = [OwnerController::class])
class OwnerControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var ownerService: OwnerService

    lateinit var owner: Owner

    @BeforeEach
    fun setUp() {
        owner = Owner().apply {
            firstName = "Math"
            lastName = "Smith"
        }
    }

    @Test
    fun listOwners() {
        val owners =
            setOf(
                Owner().apply { id = 1L },
                Owner().apply { id = 2L },
            )
        every { ownerService.findAll() } returns owners
        mockMvc.perform(get("/owners/"))
            .andExpect(status().isOk)
            .andExpect(view().name("owners/index"))
    }

    @Test
    fun findOwners() {
    }
}