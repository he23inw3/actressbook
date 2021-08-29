package jp.hiro72.controller

import jp.hiro72.controller.form.NiceForm
import jp.hiro72.entity.NiceEntity
import jp.hiro72.entity.VersionEntity
import jp.hiro72.service.ActressService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @PostMapping("/nice")
    @ResponseBody
    fun nice(@RequestBody niceForm: NiceForm): NiceEntity {
        return actressService.niceCountUp(niceForm.actressId, niceForm.userId).find {
            it.actressId == niceForm.actressId
        }?.let {
            NiceEntity(it.actressId, it.niceCnt)
        } ?: throw IllegalArgumentException()
    }

    @GetMapping("/version")
    @ResponseBody
    fun version(): VersionEntity {
        return VersionEntity(System.getenv("APP_VERSION"))
    }
}