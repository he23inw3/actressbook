package jp.hiro72.entity

import java.time.LocalDateTime

data class UserEntity(
    val name: String,
    val password: String,
    val rePassword: String?
)