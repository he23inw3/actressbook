package jp.hiro72.service

import jp.hiro72.entity.InfoEntity
import jp.hiro72.repository.InfoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InfoService(
    private val infoRepository: InfoRepository
) {

    @Transactional(readOnly = true)
    fun selectActressList(): List<InfoEntity> {
        return infoRepository.selectActressList()
    }
}