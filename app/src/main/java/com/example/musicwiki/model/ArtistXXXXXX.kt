package com.example.musicwiki.model

import com.google.gson.annotations.SerializedName

data class ArtistXXXXXX(
    @SerializedName("@attr") val attr: AttrXXXXXXXX,
    val image: List<ImageXXXXX>,
    val mbid: String,
    val name: String,
    val streamable: String,
    val url: String
)