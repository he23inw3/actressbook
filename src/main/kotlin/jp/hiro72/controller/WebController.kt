package jp.hiro72.controller

import jp.hiro72.service.ActressService
import jp.hiro72.service.InfoService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
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
        model["affiliateId"] = System.getenv("AFFILIATE_ID")
        return "actress"
    }

    @GetMapping("/info")
    fun info(model: Model): String {
        model["infoList"] = infoService.selectInfoList()
        model["affiliateId"] = System.getenv("AFFILIATE_ID")
        return "info"
    }

    private fun generateOperatorId(): String {
        return "tmp" + UUID.randomUUID().toString()
    }
}