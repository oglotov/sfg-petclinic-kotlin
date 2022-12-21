package ua.wwind.glotov.sfgpetclinickotlin.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService

@RequestMapping("/owners")
@Controller
class OwnerController @Autowired constructor(private val ownerService: OwnerService) {

    companion object {
        const val VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm"
    }

    @InitBinder
    fun setAllowedFields(dataBinder: WebDataBinder) {
        dataBinder.setDisallowedFields("id")
    }

    @GetMapping("/new")
    fun initCreationForm(model: Model): String {
        model.addAttribute("owner", Owner())
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM
    }

    @PostMapping("/new")
    fun processCreationForm(owner: Owner, result: BindingResult): String {
        return if (result.hasErrors()) {
            VIEWS_OWNER_CREATE_OR_UPDATE_FORM
        } else {
            ownerService.save(owner)
            "redirect:/owners/${owner.id}"
        }
    }

    @GetMapping("/{ownerId}/edit")
    fun initUpdateOwnerForm(@PathVariable("ownerId") ownerId: Long, model: Model): String {
        val owner = ownerService.findById(ownerId)
        model.addAttribute("owner", owner)
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM
    }

    @PostMapping("/{ownerId}/edit")
    fun processUpdateOwnerForm(owner: Owner, result: BindingResult, @PathVariable("ownerId") ownerId: Long): String {
        return if (result.hasErrors()) {
            VIEWS_OWNER_CREATE_OR_UPDATE_FORM
        } else {
            owner.id = ownerId
            ownerService.save(owner)
            "redirect:/owners/{ownerId}"
        }
    }

    @GetMapping("", "/", "/index", "/index.html")
    fun listOwners(owner: Owner, result: BindingResult, model: Model): String {
        val results = ownerService.findByLastName(owner.lastName)
        return when {
            results.isEmpty() -> {
                // no owners found
                result.rejectValue("lastName", "notFound", "not found")
                "owners/findOwners"
            }
            results.size == 1 -> {
                // 1 owner found
                "redirect:/owners/${results.first().id}"
            }
            else -> {
                // multiple owners found
                model.addAttribute("owners", results)
                "owners/index"
            }
        }
    }

    @GetMapping("/find")
    fun findOwners(model: Model): String {
        model.addAttribute("owner", Owner())
        return "owners/findOwners"
    }

    @GetMapping("/{ownerId}")
    fun showOwner(@PathVariable ownerId: String, model: Model): String {
        model.addAttribute("owner", ownerService.findById(ownerId.toLong()))
        return "owners/ownerDetails"
    }
}