package jp.hiro72.repository

import jp.hiro72.entity.ActressEntity
import jp.hiro72.exception.ExceptionFactory
import jp.hiro72.mapper.ActressMapper
import org.apache.ibatis.exceptions.PersistenceException
import org.springframework.stereotype.Repository

@Repository
class ActressRepository(
    private val exceptionFactory: ExceptionFactory,
    private val actressMapper: ActressMapper
) {

    fun selectActressInformationList(): List<ActressEntity> {
        return try {
            actressMapper.selectActressList().map {
                ActressEntity(
                    it.actressId,
                    it.name,
                    it.height,
                    it.bust,
                    it.west,
                    it.hip,
                    it.imageUrl,
                    it.infoUrl,
                    it.birthday,
                    it.niceCnt
                )
            }
        } catch (e: PersistenceException) {
            throw exceptionFactory.createDataAccessException(e)
        }
    }
}