package ua.wwind.glotov.sfgpetclinickotlin.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.model.Pet
import ua.wwind.glotov.sfgpetclinickotlin.model.PetType
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService
import ua.wwind.glotov.sfgpetclinickotlin.services.PetService
import ua.wwind.glotov.sfgpetclinickotlin.services.PetTypeService

@Controller
@RequestMapping("/owners/{ownerId}")
class PetController(
    private val petService: PetService,
    private val petTypeService: PetTypeService,
    private val ownerService: OwnerService
) {
    companion object {
        const val VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm"
    }
    @ModelAttribute("types")
    fun populatePetTypes(): Collection<PetType> = petTypeService.findAll()

    @ModelAttribute("owner")
    fun findOwner(@PathVariable("ownerId") ownerId: Long): Owner?
            = ownerService.findById(ownerId)

    @InitBinder("owner")
    fun initOwnerBinder(dataBinder: WebDataBinder) {
        dataBinder.setDisallowedFields("id")
    }
    @GetMapping("/pets/new")
    fun initCreationForm(owner: Owner?, model: Model): String {
        val pet = Pet()
        pet.owner = owner
        model["pet"] = pet
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM
    }

    @PostMapping("/pets/new")
    fun processCreationForm(owner: Owner?, pet: Pet, result: BindingResult, model: Model): String {
        if (pet.name.isNotBlank() && pet.isNew && owner!!.pets.any { it.name == pet.name }) {
            result.rejectValue("name", "duplicate", "already exists")
        }
        pet.owner = owner
        return if (result.hasErrors()) {
            println(result.allErrors.toString())
            model["pet"] = pet
            VIEWS_PETS_CREATE_OR_UPDATE_FORM
        } else {
            owner?.pets?.add(pet)
            petService.save(pet)
            "redirect:/owners/{ownerId}"
        }
    }

    @GetMapping("/pets/{petId}/edit")
    fun initUpdateForm(@PathVariable petId: Long, model: Model): String {
        val pet = petService.findById(petId) ?: return "redirect:$VIEWS_PETS_CREATE_OR_UPDATE_FORM"
        model["pet"] = pet
        return VIEWS_PETS_CREATE_OR_UPDATE_FORM
    }

    @PostMapping("/pets/{petId}/edit")
    fun processUpdateForm(pet: Pet, result: BindingResult, owner: Owner, model: Model): String {
        pet.owner = owner
        return if (result.hasErrors()) {
            model["pet"] = pet
            VIEWS_PETS_CREATE_OR_UPDATE_FORM
        } else {
            petService.save(pet)
            "redirect:/owners/{ownerId}"
        }
    }

}