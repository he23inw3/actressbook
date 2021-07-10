package jp.hiro72.service

import jp.hiro72.entity.UserEntity
import jp.hiro72.exception.ExceptionFactory
import jp.hiro72.mapper.input.UserInformation
import jp.hiro72.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val exceptionFactory: ExceptionFactory,
    private val userRepository: UserRepository
) {

    @Transactional
    fun registerUserInformation(entity: UserEntity) {
        val result = userRepository.registerUserInformation(entity)
        if (result == 0) {
            exceptionFactory.createBusinessCheckException()
        }
    }
}