package ua.wwind.glotov.sfgpetclinickotlin.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {
    @GetMapping("/","", "index", "index.html")
    fun index(): String {
        return "index"
    }
}