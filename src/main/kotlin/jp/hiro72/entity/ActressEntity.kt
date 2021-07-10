package jp.hiro72.entity

import java.time.LocalDate

data class ActressEntity(
    val name: String,
    val bust: Int,
    val west: Int,
    val hip: Int,
    val imageUrl: String,
    val infoUrl: String,
    val birthday: LocalDate,
    val niceCnt: Int
) {
    fun getAge(): Int {
        var age = LocalDate.now().year - birthday.year
        if (LocalDate.now().month < birthday.month) {
            age -= 1
        } else if (LocalDate.now().month == birthday.month &&
            LocalDate.now().dayOfMonth < birthday.dayOfMonth) {
            age -= 1
        }
        return age
    }
}
