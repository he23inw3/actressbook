package jp.hiro72.repository

import jp.hiro72.constant.Category
import jp.hiro72.entity.InfoEntity
import jp.hiro72.mapper.InfoMapper
import jp.hiro72.mapper.model.InfoRecord
import org.springframework.stereotype.Repository

@Repository
class InfoRepository(
    private val infoMapper: InfoMapper
) {

    fun selectInfoList(): List<InfoEntity> {
        return infoMapper.selectInfoList().map { createInfoEntity(it) }
    }

    private fun createInfoEntity(infoRecord: InfoRecord) = InfoEntity(
        infoRecord.infoId,
        infoRecord.title,
        Category.resolve(infoRecord.category),
        infoRecord.infoUrl,
        infoRecord.createdDate
    )
}