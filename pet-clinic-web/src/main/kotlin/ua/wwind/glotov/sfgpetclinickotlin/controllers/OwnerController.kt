package ua.wwind.glotov.sfgpetclinickotlin.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.InitBinder
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import ua.wwind.glotov.sfgpetclinickotlin.model.Owner
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService

@RequestMapping("/owners")
@Controller
class OwnerController @Autowired constructor(private val ownerService: OwnerService) {

    @InitBinder
    fun setAllowedFields(dataBinder: WebDataBinder) {
        dataBinder.setDisallowedFields("id")
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