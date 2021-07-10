package jp.hiro72.controller

import jp.hiro72.exception.BusinessCheckException
import jp.hiro72.exception.DataCheckException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionController {

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    @ExceptionHandler(BusinessCheckException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun businessCheckHandler(e: BusinessCheckException): String {
        logger.error("業務処理エラー発生。", e)
        return "error"
    }

    @ExceptionHandler(DataCheckException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun dataCheckException(e: DataCheckException): String {
        logger.error("入力チェックエラー発生", e)
        return "error"
    }

    @ExceptionHandler(Throwable::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun internalError(th: Throwable): String {
        logger.error("想定外エラー発生", th)
        return "error"
    }
}