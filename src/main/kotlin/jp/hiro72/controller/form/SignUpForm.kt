package jp.hiro72.controller.form

data class SignUpForm(
    val name: String,
    val password: String,
    val rePassword: String?
)