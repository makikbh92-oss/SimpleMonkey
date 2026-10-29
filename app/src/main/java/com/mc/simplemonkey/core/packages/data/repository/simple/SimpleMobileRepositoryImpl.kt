package com.mc.simplemonkey.core.packages.data.repository.simple
import com.mc.simplemonkey.core.common.safeCall
import com.mc.simplemonkey.core.packages.data.remote.api.MobileApi
import com.mc.simplemonkey.core.packages.data.repository.simple.utils.toVOList
import com.mc.simplemonkey.core.packages.domain.model.simple.MakerVO
import com.mc.simplemonkey.core.packages.domain.model.simple.PhoneVO
import com.mc.simplemonkey.core.packages.domain.repository.simple.SimpleMobileRepository
import javax.inject.Inject

class SimpleMobileRepositoryImpl @Inject constructor(
    private val mobileApi: MobileApi
) : SimpleMobileRepository {

    override suspend fun getMakers(tkIdx: Int): Result<List<MakerVO>> = safeCall {
        mobileApi.getModeListMobileMaker(
            tkIdx = tkIdx
        )
    }.map {
        it.toVOList()
    }

    override suspend fun getMobileList(tkIdx: Int, mkIdx: Int): Result<List<PhoneVO>> = safeCall {
        mobileApi.getModeListMobileTrend(
            tkIdx = tkIdx,
            mkIdx = mkIdx
        )
    }.map { it.toVOList() }

    override suspend fun getMobileDetail(tkIdx: Int, mdIdx: Int): Result<Boolean> = safeCall {
        mobileApi.getModeDetailData(
            tkIdx = tkIdx,
            mdIdx = mdIdx
        )
    }.map {
        it.list.firstOrNull()?.isHalbuMonth48 == "Y"
    }
}
