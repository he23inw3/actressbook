package jp.hiro72.controller

import jp.hiro72.service.ActressService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.util.*

@Controller
class WebController(
    private val actressService: ActressService
) {

    @GetMapping("/")
    fun top(model: Model): String {
        model["operatorId"] = generateOperatorId()
        model["actressList"] = actressService.selectActressList()
        return "top"
    }

    @PostMapping("/nice")
    fun nice(model: Model): String {
        return "redirect:/"
    }

    private fun generateOperatorId(): String {
        return UUID.randomUUID().toString()
    }
}