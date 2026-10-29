package com.mc.simplemonkey.core.packages.data.remote.api


import com.mc.network.ApiClient
import com.mc.simplemonkey.core.packages.data.remote.model.PhoneDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import javax.inject.Inject

class PhoneSpecApi @Inject constructor(
    private val apiClient: ApiClient,
    private val json: Json,
) {
    // 제조사 목록
    suspend fun getModeDetailData(
        psIdx: Int
    ): PhoneDetailResponse = withContext(Dispatchers.IO) {
        val raw = apiClient.post(
            url = "_app/phoneSpec/modeDetailData", // TODO: 실제 경로로 변경
            params = mapOf("ps_idx" to psIdx.toString()), // TODO: 실제 파라미터 이름으로 변경
        ).string()
        json.decodeFromString<PhoneDetailResponse>(raw)
    }





}