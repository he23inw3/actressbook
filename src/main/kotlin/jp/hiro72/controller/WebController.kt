package jp.hiro72.controller

import jp.hiro72.service.ActressService
import jp.hiro72.service.InfoService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

@Controller
class WebController(
    private val actressService: ActressService,
    private val infoService: InfoService
) {

    @GetMapping("/")
    fun actress(model: Model): String {
        model["userId"] = generateOperatorId()
        model["actressList"] = actressService.selectActressList()
        return "actress"
    }

    @GetMapping("/info")
    fun info(model: Model): String {
        model["infoList"] = infoService.selectInfoList()
        return "info"
    }

    private fun generateOperatorId(): String {
        return "tmp" + UUID.randomUUID().toString()
    }
}