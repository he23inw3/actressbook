package jp.hiro72.exception

import java.lang.RuntimeException

class DataCheckException(message: String?, cause: Throwable?) : RuntimeException(message, cause)