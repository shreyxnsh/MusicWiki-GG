package com.example.musicwiki.model

import com.google.gson.annotations.SerializedName

data class Albums(
    @SerializedName("@attr") val attr: AttrXXXXX,
    val album: List<AlbumXX>
)