package jp.hiro72.entity

import java.time.LocalDate

data class ActressEntity(
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
) {
    fun getAge(): Int {
        val now = LocalDate.now()
        var age = now.year - birthday.year
        if (now.month < birthday.month) {
            age -= 1
        } else if (now.month == birthday.month &&
            now.dayOfMonth < birthday.dayOfMonth) {
            age -= 1
        }
        return age
    }
}
