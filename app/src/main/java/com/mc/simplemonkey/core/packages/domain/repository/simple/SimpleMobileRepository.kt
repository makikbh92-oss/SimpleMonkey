package com.mc.simplemonkey.core.packages.domain.repository.simple


import com.mc.simplemonkey.core.packages.domain.model.simple.MakerVO
import com.mc.simplemonkey.core.packages.domain.model.simple.PhoneVO


interface SimpleMobileRepository {
    suspend fun getMakers(tkIdx : Int) : Result<List<MakerVO>>

    suspend fun getMobileList(tkIdx : Int, mkIdx: Int) : Result<List<PhoneVO>>

    suspend fun getMobileDetail(
        tkIdx: Int,
        mdIdx: Int) : Result<Boolean>


}