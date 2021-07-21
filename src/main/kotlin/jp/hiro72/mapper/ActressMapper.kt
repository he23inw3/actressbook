package jp.hiro72.mapper

import jp.hiro72.mapper.model.ActressRecord
import org.apache.ibatis.annotations.Mapper

@Mapper
interface ActressMapper {

    fun selectActressList(): List<ActressRecord>
}