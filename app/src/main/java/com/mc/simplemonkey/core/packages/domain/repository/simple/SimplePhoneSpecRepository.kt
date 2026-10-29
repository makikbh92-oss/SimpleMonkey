package com.mc.simplemonkey.core.packages.domain.repository.simple


interface SimplePhoneSpecRepository {
    suspend fun getPhoneSpecDetail(psIdx : Int) : Result<String>
}