package ua.wwind.glotov.sfgpetclinickotlin.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import ua.wwind.glotov.sfgpetclinickotlin.services.VetSevice

@RequestMapping("/vets")
@Controller
class VetController @Autowired constructor(private val vetService: VetSevice) {
    @GetMapping("", "/", "/index", "/index.html")
    fun listVets(model: Model): String {
        model.addAttribute("vets", vetService.findAll())
        return "vets/index"
    }
}