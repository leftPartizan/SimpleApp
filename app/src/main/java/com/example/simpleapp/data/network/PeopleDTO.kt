package com.example.simpleapp.data.network

import com.google.gson.annotations.SerializedName

data class PeopleDTO(
    @SerializedName("name") val name: String,
    @SerializedName("height") val height: String,
    @SerializedName("mass") val mass: String,
    @SerializedName("birth_year") val birthYear: String,
    @SerializedName("gender") val gender: String
)