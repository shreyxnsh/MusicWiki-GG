package com.example.musicwiki.model

import com.google.gson.annotations.SerializedName

data class Toptracks(
    @SerializedName("@attr") val attr: AttrXXX,
    val track: List<TrackX>
)