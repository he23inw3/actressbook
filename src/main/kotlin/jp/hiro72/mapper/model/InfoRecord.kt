package jp.hiro72.mapper.model

import java.time.LocalDate

data class InfoRecord(
    val infoId: Int,
    val title: String,
    val category: String,
    val infoUrl: String,
    val createdDate: LocalDate
)
