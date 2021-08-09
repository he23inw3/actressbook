package jp.hiro72.controller

import jp.hiro72.controller.form.ActressForm
import jp.hiro72.service.ActressService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.util.*

@Controller
class WebController(
    private val actressService: ActressService
) {

    @GetMapping("/")
    fun top(model: Model, userId: String?): String {
        model["userId"] = userId ?: generateOperatorId()
        model["actressList"] = actressService.selectActressList()
        return "top"
    }

    @PostMapping("/niceup")
    fun niceUp(@ModelAttribute form: ActressForm, model: Model, redirectAttribute: RedirectAttributes): String {
        actressService.niceCountUp(form.actressId, form.userId)
        redirectAttribute.addAttribute("userId", form.userId)
        return "redirect:/"
    }

    private fun generateOperatorId(): String {
        return "tmp" + UUID.randomUUID().toString()
    }
}