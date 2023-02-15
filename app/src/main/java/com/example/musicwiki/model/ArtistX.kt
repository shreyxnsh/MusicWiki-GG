package com.example.musicwiki.model

data class ArtistX(
    val bio: Bio,
    val image: List<ImageX>,
    val mbid: String,
    val name: String,
    val ontour: String,
    val similar: Similar,
    val stats: Stats,
    val streamable: String,
    val tags: TagsX,
    val url: String
)