package com.mc.simplemonkey.core.packages.domain.usecase.simple

import com.mc.simplemonkey.core.packages.domain.model.simple.PhoneVO
import com.mc.simplemonkey.core.packages.domain.repository.simple.SimpleMobileRepository
import com.mc.simplemonkey.core.packages.domain.repository.simple.SimplePhoneSpecRepository

import javax.inject.Inject

class ChangePhoneUseCase @Inject constructor(
    private val mobile: SimpleMobileRepository,
    private val phoneSpec: SimplePhoneSpecRepository,
) {
    suspend operator fun invoke(
        phone: PhoneVO,
        tkIdx: Int,
    ): Result<PhoneVO> {
        val isHalbu = mobile.getMobileDetail(
            tkIdx = tkIdx,
            mdIdx = phone.modelIndex,
        ).getOrElse { return Result.failure(it) }

        val imageUrl = phoneSpec.getPhoneSpecDetail(phone.index)
            .getOrElse { return Result.failure(it) }

        return Result.success(
            phone.copy(
                isHalbuMonth48 = isHalbu,
                imageUrl = imageUrl,
            )
        )
    }


}