package com.mc.simplemonkey.core.packages.data.repository.simple

import com.mc.simplemonkey.core.common.safeCall
import com.mc.simplemonkey.core.packages.domain.repository.simple.SimplePhoneSpecRepository
import com.mc.simplemonkey.core.packages.data.remote.api.PhoneSpecApi
import javax.inject.Inject

class SimplePhoneSpecRepositoryImpl @Inject constructor(
    private val phoneSpecApi: PhoneSpecApi
) : SimplePhoneSpecRepository {

    override suspend fun getPhoneSpecDetail(psIdx : Int): Result<String> = safeCall {
        phoneSpecApi.getModeDetailData(
            psIdx = psIdx
        )
    }.map {
        it.phoneImages.firstOrNull()?.piPath.orEmpty()
    }







}