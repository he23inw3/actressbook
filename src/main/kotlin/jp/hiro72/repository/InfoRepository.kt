package jp.hiro72.repository

import jp.hiro72.constant.Category
import jp.hiro72.entity.InfoEntity
import jp.hiro72.exception.ExceptionFactory
import jp.hiro72.mapper.InfoMapper
import jp.hiro72.mapper.model.InfoRecord
import org.apache.ibatis.exceptions.PersistenceException
import org.springframework.stereotype.Repository

@Repository
class InfoRepository(
    private val exceptionFactory: ExceptionFactory,
    private val infoMapper: InfoMapper
) {

    fun selectActressList(): List<InfoEntity> {
        return try {
            infoMapper.selectActressList().map { createInfoEntity(it) }
        } catch (e: PersistenceException) {
            throw exceptionFactory.createDataAccessException(e)
        }
    }

    internal fun createInfoEntity(infoRecord: InfoRecord) = InfoEntity(
        infoRecord.infoId,
        infoRecord.title,
        Category.values().find { c -> c.categoryCode == infoRecord.category } ?: Category.UNDEFINED,
        infoRecord.infoUrl,
        infoRecord.createdDate
    )
}