package com.example.musicwiki.model

import com.google.gson.annotations.SerializedName

data class TrackXX(
    @SerializedName("@attr") val attr: AttrXXXXXXXXXX,
    val artist: ArtistXXXXXXX,
    val duration: String,
    val image: List<ImageXXXXXX>,
    val mbid: String,
    val name: String,
    val streamable: StreamableX,
    val url: String
)