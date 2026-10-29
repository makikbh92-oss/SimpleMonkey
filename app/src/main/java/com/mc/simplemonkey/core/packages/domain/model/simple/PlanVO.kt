package com.mc.simplemonkey.core.packages.domain.model.simple

data class PlanVO (
    val index: Int = 0,
    val name: String = "",
    val price: Int = 0,
    val lte: String = "",
    val tel: String = "",
    val sms: String = "",
    val gongsi: Int = 0,
    val choiceBasic: Int = 0,
    val choice12Month: Int = 0,
    val choice24Month: Int = 0,
    val choice36Month: Int = 0,
)