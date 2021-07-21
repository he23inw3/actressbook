package jp.hiro72.mapper.model

import java.time.LocalDate

data class ActressRecord(
    val name: String,
    val bust: Int,
    val west: Int,
    val hip: Int,
    val imageUrl: String,
    val infoUrl: String,
    val birthday: LocalDate,
    val niceCnt: Int
)
