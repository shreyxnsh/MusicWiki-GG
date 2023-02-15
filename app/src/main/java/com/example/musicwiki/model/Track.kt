package com.example.musicwiki.model

import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("@attr") val attr: AttrX,
    val artist: Artist,
    val duration: Int,
    val name: String,
    val streamable: Streamable,
    val url: String
)