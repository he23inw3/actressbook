package jp.hiro72.service

import jp.hiro72.entity.ActressEntity
import jp.hiro72.repository.ActressRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ActressService(
    private val actressRepository: ActressRepository
) {

    @Transactional(readOnly = true)
    fun selectActressList(): List<ActressEntity> {
        return actressRepository.selectActressInformationList()
    }
}