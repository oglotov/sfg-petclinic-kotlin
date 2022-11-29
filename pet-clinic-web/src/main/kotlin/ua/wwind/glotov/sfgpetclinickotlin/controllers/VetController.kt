package ua.wwind.glotov.sfgpetclinickotlin.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/vets")
@Controller
class VetController {
    @GetMapping("", "/", "/index", "/index.html")
    fun listVets() = "vets/index"
}