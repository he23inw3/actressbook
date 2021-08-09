package jp.hiro72.repository

import jp.hiro72.exception.ExceptionFactory
import jp.hiro72.mapper.NiceMapper
import org.apache.ibatis.exceptions.PersistenceException
import org.springframework.stereotype.Repository

@Repository
class NiceRepository(
    private val exceptionFactory: ExceptionFactory,
    private val niceMapper: NiceMapper
) {

    fun isRegisteredNice(actressId: Int, userId: String): Boolean {
        return try {
            niceMapper.isRegisteredNice(actressId, userId)
        } catch (e: PersistenceException) {
            throw exceptionFactory.createDataAccessException(e)
        }
    }

    fun niceCountUp(actressId: Int, userId: String): Int {
        return try {
            niceMapper.niceCountUp(actressId, userId)
        } catch (e: PersistenceException) {
            throw exceptionFactory.createDataAccessException(e)
        }
    }

    fun niceCountDown(actressId: Int, userId: String): Int {
        return try {
            niceMapper.niceCountDown(actressId, userId)
        } catch (e: PersistenceException) {
            throw exceptionFactory.createDataAccessException(e)
        }
    }
}