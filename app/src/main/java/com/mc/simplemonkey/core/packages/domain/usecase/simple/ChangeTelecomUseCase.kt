package com.mc.simplemonkey.core.packages.domain.usecase.simple



import com.mc.simplemonkey.core.packages.domain.model.simple.ConsultingVO
import com.mc.simplemonkey.core.packages.domain.model.simple.MakerVO
import com.mc.simplemonkey.core.packages.domain.model.simple.TelecomType
import com.mc.simplemonkey.core.packages.domain.repository.simple.SimpleMobileRepository
import javax.inject.Inject

class ChangeTelecomUseCase @Inject constructor(
    private val repository: SimpleMobileRepository
) {
    suspend operator fun invoke(
        telecomType: TelecomType,
        maker: MakerVO? = null,
    ): Result<ConsultingVO> =
        repository.getMakers(telecomType.index).map {
            makers ->
            val result = maker
                ?.takeIf { current -> makers.any { it.index == current.index } }
                ?: makers.first()

            ConsultingVO(
                telecomType = telecomType,
                makerList = makers,
                maker = result,
            )
        }



}