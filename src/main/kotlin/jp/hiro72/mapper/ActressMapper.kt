package jp.hiro72.mapper

import jp.hiro72.mapper.output.ActressRecord
import org.apache.ibatis.annotations.Mapper

@Mapper
interface ActressMapper {

    fun selectActressList(): List<ActressRecord>
}