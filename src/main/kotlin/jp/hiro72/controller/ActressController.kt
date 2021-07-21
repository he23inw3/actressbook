package jp.hiro72.controller

import jp.hiro72.service.ActressService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ActressController(
    private val actressService: ActressService
) {

    @GetMapping("/")
    fun top(model: Model): String {
        model["actressList"] = actressService.selectActressList()
        return "top"
    }
}