package jp.hiro72.mapper

import jp.hiro72.mapper.model.InfoRecord
import org.apache.ibatis.annotations.Mapper

@Mapper
interface InfoMapper {

    fun selectInfoList(): List<InfoRecord>
}