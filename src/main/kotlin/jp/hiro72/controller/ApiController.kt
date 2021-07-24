package jp.hiro72.controller

import jp.hiro72.entity.FixedActressEntity
import jp.hiro72.entity.ModeChangeEntity
import jp.hiro72.entity.NiceFixEntity
import jp.hiro72.entity.VersionEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/system")
@CrossOrigin
class ApiController{

    /**
     * いいね数確定API
     *
     */
    @PostMapping("/nice_fix")
    fun niceFix(@RequestHeader("user-agent") userAgent: String): NiceFixEntity {
        return NiceFixEntity(
            1,
            listOf(FixedActressEntity("00000001", 1))
        )
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