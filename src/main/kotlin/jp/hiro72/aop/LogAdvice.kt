package jp.hiro72.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LogAdvice {

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    @Before("within(jp.hiro72.controller.WebController)")
    fun webControllerStartLog(jp: JoinPoint) {
        logger.info("START: {}, ARGS: {}", jp.toShortString(), jp.args.toList())
    }

    @After("within(jp.hiro72.controller.WebController)")
    fun webControllerEndLog(jp: JoinPoint) {
        logger.info("END: {}, ARGS: {}", jp.toShortString(), jp.args.toList())
    }

    @Before("within(jp.hiro72.controller.ApiController)")
    fun apiControllerStartLog(jp: JoinPoint) {
        logger.info("START: {}, ARGS: {}", jp.toShortString(), jp.args.toList())
    }

    @AfterReturning("within(jp.hiro72.controller.ApiController)", returning = "res")
    fun apiControllerEndLog(jp: JoinPoint, res: Object) {
        logger.info("END: {}, ARGS: {}", jp.toShortString(), res.toString())
    }
}