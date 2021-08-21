package jp.hiro72.controller

import jp.hiro72.controller.form.NiceForm
import jp.hiro72.entity.ModeChangeEntity
import jp.hiro72.entity.NiceEntity
import jp.hiro72.entity.VersionEntity
import jp.hiro72.service.ActressService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.lang.IllegalArgumentException

@RestController
@RequestMapping("/api/system")
@CrossOrigin
class ApiController(
    private val actressService: ActressService,
){

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    /**
     * いいねAPI
     *
     */
    @PostMapping("/nice")
    @ResponseBody
    fun nice(@RequestBody niceForm: NiceForm): NiceEntity {
        logger.info("いいねAPI 要求=$niceForm")
        return actressService.niceCountUp(niceForm.actressId, niceForm.userId).find {
            it.actressId == niceForm.actressId
        }?.let {
            NiceEntity(it.actressId, it.niceCnt)
        } ?: throw IllegalArgumentException()
    }

    /**
     * モード切替API
     *
     */
    @PostMapping("/mode_change")
    fun modeChange(@RequestHeader("user-agent") userAgent: String): ModeChangeEntity {
        return ModeChangeEntity(
            "通常モード"
        )
    }

    /**
     * バージョン取得API
     *
     * @return
     */
    @GetMapping("/version")
    fun version(): VersionEntity {
        return VersionEntity("1.0.0")
    }
}