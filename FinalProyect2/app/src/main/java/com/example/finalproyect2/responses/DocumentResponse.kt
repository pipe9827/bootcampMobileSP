package com.example.finalproyect2.responses

import com.google.gson.annotations.SerializedName

data class DocumentResponse (
    @SerializedName("Items") val documents: List<Documents>
        )