package jp.hiro72.repository

import jp.hiro72.entity.ActressEntity
import jp.hiro72.mapper.ActressMapper
import jp.hiro72.mapper.model.ActressRecord
import org.springframework.stereotype.Repository

@Repository
class ActressRepository(
    private val actressMapper: ActressMapper
) {

    fun selectActressInformationList(): List<ActressEntity> {
        return actressMapper.selectActressList().map { createActressEntity(it) }
    }

    private fun createActressEntity(actressRecord: ActressRecord) = ActressEntity(
        actressRecord.actressId,
        actressRecord.name,
        actressRecord.height,
        actressRecord.bust,
        actressRecord.west,
        actressRecord.hip,
        actressRecord.imageUrl,
        actressRecord.infoUrl,
        actressRecord.birthday,
        actressRecord.niceCnt
    )
}