package jp.hiro72.mapper

import jp.hiro72.mapper.input.UserInformation
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {

    fun registerUserInformation(information: UserInformation): Int

    fun checkRegisteredUser(information: UserInformation): Boolean
}