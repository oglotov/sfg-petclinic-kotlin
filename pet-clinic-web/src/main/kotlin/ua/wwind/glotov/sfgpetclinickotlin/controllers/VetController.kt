package ua.wwind.glotov.sfgpetclinickotlin.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class VetController {
    @GetMapping("/vets", "/vets/", "/vets/index", "/vets/index.html")
    fun listVets() = "vets/index"
}