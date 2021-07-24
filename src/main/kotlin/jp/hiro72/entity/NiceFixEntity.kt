package jp.hiro72.entity

data class NiceFixEntity(
    val totalFixActressCnt: Int,
    val actressList: List<FixedActressEntity>
)

data class FixedActressEntity(
    val actressId: String,
    val fiNiceCnt: Int
)