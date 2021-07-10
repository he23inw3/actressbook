package jp.hiro72.controller

import jp.hiro72.entity.UserEntity
import jp.hiro72.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class UserController(
    private val userService: UserService
) {

    @GetMapping("/signup")
    fun getSignup(model: Model): String {
        return "signup"
    }

    @PostMapping("/signup")
    fun postSignup(model: Model): String {
        userService.registerUserInformation(
            UserEntity(
                model.getAttribute("name") as String,
                model.getAttribute("password") as String,
                null
            )
        )
        return "top"
    }
}