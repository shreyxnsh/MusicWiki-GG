package com.example.musicwiki.model

import com.google.gson.annotations.SerializedName

data class AlbumXX(
    @SerializedName("@attr") val attr: AttrXXXXXX,
    val artist: ArtistXXXXX,
    val image: List<ImageXXXX>,
    val mbid: String,
    val name: String,
    val url: String
)