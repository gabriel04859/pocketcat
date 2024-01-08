package com.gabsa.pocketcat.data.model

import com.google.gson.annotations.SerializedName

data class CatDTO(
    val height: Int?,
    val id: String?,
    val url: String?,
    val width: Int?,
    @SerializedName("breeds")
    val breeds: List<BreedsDTOItem>
)