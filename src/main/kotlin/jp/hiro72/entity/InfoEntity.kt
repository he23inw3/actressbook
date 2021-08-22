package jp.hiro72.entity

import jp.hiro72.constant.Category
import java.time.LocalDate

data class InfoEntity(
    val infoId: Int,
    val title: String,
    val category: Category,
    val infoUrl: String,
    val createdDate: LocalDate
)
