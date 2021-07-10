package jp.hiro72.exception

import org.springframework.stereotype.Component

@Component
class ExceptionFactory {

    fun createDataAccessException(th: Throwable): DataCheckException {
        return DataCheckException(th.message, th)
    }

    fun createBusinessCheckException(): BusinessCheckException {
        return BusinessCheckException()
    }
}