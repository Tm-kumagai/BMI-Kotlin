package com.example.bmiapplication

import com.fasterxml.jackson.annotation.JsonProperty
import java.text.SimpleDateFormat
import java.util.*

val unUseDate = Date()
val dateFormat = SimpleDateFormat("yyyyMMdd")
val today: String = dateFormat.format(unUseDate)

data class RecordData(
    @JsonProperty("date")
    var date: String = today,

    @JsonProperty("height")
    var height: String = "",

    @JsonProperty("weight")
    var weight: String = "",

    @JsonProperty("bmi")
    var bmi: String = ""
)