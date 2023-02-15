package com.example.musicwiki.model

import com.google.gson.annotations.SerializedName

data class Topalbums(
    @SerializedName("@attr") val attr: AttrXX,
    val album: List<AlbumX>
)