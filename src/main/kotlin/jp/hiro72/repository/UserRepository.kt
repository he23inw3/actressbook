package jp.hiro72.repository

import jp.hiro72.entity.UserEntity
import jp.hiro72.exception.ExceptionFactory
import jp.hiro72.mapper.UserMapper
import jp.hiro72.mapper.input.UserInformation
import org.apache.ibatis.exceptions.PersistenceException
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    private val exceptionFactory: ExceptionFactory,
    private val userMapper: UserMapper
) {

    fun registerUserInformation(entity: UserEntity): Int {
        return try {
            userMapper.registerUserInformation(
                UserInformation(
                    entity.name,
                    entity.password
                )
            )
        } catch (e: PersistenceException) {
            throw exceptionFactory.createDataAccessException(e)
        }
    }
}