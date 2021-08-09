package jp.hiro72.mapper.model

import java.time.LocalDate

data class ActressRecord(
    val actressId: Int,
    val name: String,
    val height: Int,
    val bust: Int,
    val west: Int,
    val hip: Int,
    val imageUrl: String,
    val infoUrl: String,
    val birthday: LocalDate,
    val niceCnt: Int
)
