package com.example.musicwiki.model

import com.google.gson.annotations.SerializedName

data class TrackX(
    @SerializedName("@attr") val attr: AttrXXXX,
    val artist: ArtistXXXX,
    val image: List<ImageXXX>,
    val listeners: String,
    val mbid: String,
    val name: String,
    val playcount: String,
    val streamable: String,
    val url: String
)