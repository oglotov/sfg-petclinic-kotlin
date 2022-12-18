package ua.wwind.glotov.sfgpetclinickotlin.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import ua.wwind.glotov.sfgpetclinickotlin.services.OwnerService

@RequestMapping("/owners")
@Controller
class OwnerController @Autowired constructor(private val ownerService: OwnerService) {

    @GetMapping("", "/", "/index", "/index.html")
    fun listOwners(model: Model): String {
        model.addAttribute("owners", ownerService.findAll())
        return "owners/index"
    }

    @GetMapping("/find")
    fun findOwners(model: Model): String {
        return "notimplemented"
    }

    @GetMapping("/{ownerId}")
    fun showOwner(@PathVariable ownerId: String, model: Model): String {
        model.addAttribute("owner", ownerService.findById(ownerId.toLong()))
        return "owners/ownerDetails"
    }
}