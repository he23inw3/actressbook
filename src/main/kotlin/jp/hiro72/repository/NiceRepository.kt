package jp.hiro72.repository

import jp.hiro72.mapper.NiceMapper
import org.springframework.stereotype.Repository

@Repository
class NiceRepository(
    private val niceMapper: NiceMapper
) {

    fun isRegisteredNice(actressId: Int, userId: String): Boolean {
        return niceMapper.isRegisteredNice(actressId, userId)
    }

    fun niceCountUp(actressId: Int, userId: String): Int {
        return niceMapper.niceCountUp(actressId, userId)
    }

    fun niceCountDown(actressId: Int, userId: String): Int {
        return niceMapper.niceCountDown(actressId, userId)
    }
}