package com.example.bmiapplication

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class RecordData (
    @JsonProperty("date")
    var date: Date = Date(),

    @JsonProperty("height")
    var height: String = "",

    @JsonProperty("weight")
    var weight: String = "",

    @JsonProperty("bmi")
    var bmi: String = ""
)