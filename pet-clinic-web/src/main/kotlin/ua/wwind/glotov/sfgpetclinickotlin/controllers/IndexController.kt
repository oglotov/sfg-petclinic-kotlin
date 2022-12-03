package ua.wwind.glotov.sfgpetclinickotlin.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {
    @GetMapping("/","", "index", "index.html")
    fun index(): String {
        return "index"
    }
    @GetMapping("/oups")
    fun oops(model: Model): String {
        return "notimplemented"
    }
}