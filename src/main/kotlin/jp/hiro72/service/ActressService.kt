package jp.hiro72.service

import jp.hiro72.entity.ActressEntity
import jp.hiro72.repository.ActressRepository
import jp.hiro72.repository.NiceRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ActressService(
    private val actressRepository: ActressRepository,
    private val niceRepository: NiceRepository
) {

    @Transactional(readOnly = true)
    fun selectActressList(): List<ActressEntity> {
        return actressRepository.selectActressInformationList()
    }

    @Transactional(rollbackFor = [Exception::class])
    fun niceCountUp(actressId: Int, userId: String): List<ActressEntity> {
        if (niceRepository.isRegisteredNice(actressId, userId)) {
            niceRepository.niceCountDown(actressId, userId)
        } else {
            niceRepository.niceCountUp(actressId, userId)
        }
        return actressRepository.selectActressInformationList()
    }
}