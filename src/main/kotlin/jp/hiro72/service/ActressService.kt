package jp.hiro72.service

import jp.hiro72.entity.ActressEntity
import jp.hiro72.repository.ActressRepository
import org.springframework.stereotype.Service

@Service
class ActressService(
    private val actressRepository: ActressRepository
) {

    fun selectActressList(): List<ActressEntity> {
        return actressRepository.selectActressInformationList()
    }
}