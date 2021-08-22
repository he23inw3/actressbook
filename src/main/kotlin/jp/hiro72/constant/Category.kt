package jp.hiro72.constant

enum class Category(
    val categoryCode: String,
    val categoryName: String
) {
    UNDEFINED("0", "UNDEFINED"),
    SALE("1", "SALE"),
    RELEASE("2", "RELEASE"),
    APOLOGY("3", "APOLOGY")
}