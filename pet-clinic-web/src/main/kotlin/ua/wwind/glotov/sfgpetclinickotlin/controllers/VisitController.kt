package ua.wwind.glotov.sfgpetclinickotlin.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import ua.wwind.glotov.sfgpetclinickotlin.model.Visit
import ua.wwind.glotov.sfgpetclinickotlin.services.PetService
import ua.wwind.glotov.sfgpetclinickotlin.services.VisitService

@Controller
class VisitController(
    private val petService: PetService,
    private val visitService: VisitService,
) {
    @InitBinder
    fun setAllowedFields(dataBinder: WebDataBinder) {
        dataBinder.setDisallowedFields("id")
    }

    /**
     * Called before each and every @RequestMapping annotated method.
     * 2 goals:
     * - Make sure we always have fresh data
     * - Since we do not use the session scope, make sure that Pet object always has an id
     * (Even though id is not part of the form fields)
     *
     * @param petId
     * @return Pet
     */
    @ModelAttribute("visit")
    fun loadPetWithVisit(@PathVariable("petId") petId: Long, model: Model): Visit {
        val pet = petService.findById(petId)!!
        model.addAttribute("pet", pet)
        val visit = Visit()
        visit.pet = pet
        return visit
    }

    // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
    @GetMapping("/owners/*/pets/{petId}/visits/new")
    fun initNewVisitForm(@PathVariable("petId") petId: Int, model: Model): String = "pets/createOrUpdateVisitForm"

    // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    fun processNewVisitForm(visit: Visit, result: BindingResult): String {
        return if (result.hasErrors()) {
            "pets/createOrUpdateVisitForm"
        } else {
            visitService.save(visit)
            "redirect:/owners/{ownerId}"
        }
    }

}