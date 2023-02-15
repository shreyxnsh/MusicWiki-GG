package com.example.musicwiki.model

import com.google.gson.annotations.SerializedName

data class Topartists(
    @SerializedName("@attr") val attr: AttrXXXXXXX,
    val artist: List<ArtistXXXXXX>
)