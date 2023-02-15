package com.example.musicwiki.api

import com.example.musicwiki.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("/2.0")
     fun getTopTags(
        @Query("method") method:String="tag.getTopTags",
        @Query("api_key") apiKey:String="3eada7763b131f5cc2c8c4a2783c0e15",
        @Query("format") format:String="json"
    ): Call<TopTagResponse>

    @GET("/2.0")
     fun getTagInfo(
        @Query("tag") tag:String,
        @Query("method") method:String="tag.getInfo",
        @Query("api_key") apiKey:String="3eada7763b131f5cc2c8c4a2783c0e15",
        @Query("format") format:String="json"
    ): Call<TagInfoResponse>

    @GET("/2.0")
    fun getAlbumInfo(
        @Query("artist") artist:String,
        @Query("album") album:String,
        @Query("method") method:String="album.getInfo",
        @Query("api_key") apiKey:String="3eada7763b131f5cc2c8c4a2783c0e15",
        @Query("format") format:String="json"
    ): Call<AlbumDetailsResponse>

    @GET("/2.0")
    fun getArtistInfo(
        @Query("artist") artist:String,
        @Query("method") method:String="artist.getinfo",
        @Query("api_key") apiKey:String="3eada7763b131f5cc2c8c4a2783c0e15",
        @Query("format") format:String="json"
    ): Call<ArtistInfoResponse>

    @GET("/2.0")
    fun getArtistAlbum(
        @Query("artist") artist:String,
        @Query("method") method:String="artist.gettopalbums",
        @Query("api_key") apiKey:String="3eada7763b131f5cc2c8c4a2783c0e15",
        @Query("format") format:String="json"
    ): Call<ArtistTopAlbums>

    @GET("/2.0")
    fun getArtistTracks(
        @Query("artist") artist:String,
        @Query("method") method:String="artist.gettoptracks",
        @Query("api_key") apiKey:String="3eada7763b131f5cc2c8c4a2783c0e15",
        @Query("format") format:String="json"
    ): Call<ArtistTracks>

    @GET("/2.0")
     fun getTagTopAlbums(
        @Query("tag") tag:String,
        @Query("method") method:String="tag.getTopAlbums",
        @Query("api_key") apiKey:String="3eada7763b131f5cc2c8c4a2783c0e15",
        @Query("format") format:String="json"
    ): Call<TagAlbumResponse>

    @GET("/2.0")
     fun getTagArtists(
        @Query("tag") tag:String,
        @Query("method") method:String="tag.getTopArtists",
        @Query("api_key") apiKey:String="3eada7763b131f5cc2c8c4a2783c0e15",
        @Query("format") format:String="json"
    ): Call<TagArtistResponse>

    @GET("/2.0")
     fun getTagTracks(
        @Query("tag") tag:String,
        @Query("method") method:String="tag.getTopTracks",
        @Query("api_key") apiKey:String="3eada7763b131f5cc2c8c4a2783c0e15",
        @Query("format") format:String="json"
    ): Call<TagTrackResponse>
}