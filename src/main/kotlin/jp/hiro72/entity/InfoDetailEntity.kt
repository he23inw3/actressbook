package jp.hiro72.entity

import java.time.LocalDate

data class InfoDetailEntity(
    val title: String,
    val content: String,
    val createdDate: LocalDate
)
