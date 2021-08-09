package jp.hiro72.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface NiceMapper {

    fun isRegisteredNice(@Param("actressId") actressId: Int, @Param("userId") userId: String): Boolean

    fun niceCountUp(@Param("actressId") actressId: Int, @Param("userId") userId: String): Int

    fun niceCountDown(@Param("actressId") actressId: Int, @Param("userId") userId: String): Int
}