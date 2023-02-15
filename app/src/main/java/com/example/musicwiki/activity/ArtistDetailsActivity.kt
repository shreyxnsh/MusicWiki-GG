package com.example.musicwiki.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.R
import com.example.musicwiki.adapter.ArtistAlbumAdapter
import com.example.musicwiki.adapter.ArtistTrackAdapter
import com.example.musicwiki.api.RetrofitInstance
import com.example.musicwiki.model.*
import kotlinx.android.synthetic.main.activity_artist_details.*
import retrofit2.Call

class ArtistDetailsActivity : AppCompatActivity() {

    var albums: MutableList<AlbumX> = mutableListOf()
    var tracks: MutableList<TrackX> = mutableListOf()
    val albumAdapter: ArtistAlbumAdapter = ArtistAlbumAdapter(albums)
    val tracksAdapter: ArtistTrackAdapter = ArtistTrackAdapter(tracks)

    lateinit var artist: String
    lateinit var image: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_details)


        artist = intent.getStringExtra("artist")!!
        tv_artist_name.text=artist

        rv_artist_albums.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rv_artist_albums.adapter=albumAdapter

        rv_top_tracks.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rv_top_tracks.adapter=tracksAdapter

        getArtistInfo()
        getTopAlbums()
        getTopTracks()
    }

    private fun getTopTracks() {
        val response = RetrofitInstance.api.getArtistTracks(artist)
        response.enqueue(
            object : retrofit2.Callback<ArtistTracks> {
                override fun onResponse(
                    call: retrofit2.Call<ArtistTracks>,
                    response: retrofit2.Response<ArtistTracks>
                ) {
                    if (response.body() != null) {

                        val top_tracks = (response.body())!!
                        tracks.addAll(top_tracks.toptracks.track)
                        tracksAdapter.notifyDataSetChanged()
                    }
                }


                override fun onFailure(call: Call<ArtistTracks>, t: Throwable) {
                    Toast.makeText(this@ArtistDetailsActivity, "Failed $t", Toast.LENGTH_LONG).show()
                }

            })

    }

    private fun getTopAlbums() {
        val response = RetrofitInstance.api.getArtistAlbum(artist)
        response.enqueue(
            object : retrofit2.Callback<ArtistTopAlbums> {
                override fun onResponse(
                    call: retrofit2.Call<ArtistTopAlbums>,
                    response: retrofit2.Response<ArtistTopAlbums>
                ) {
                    if (response.body() != null) {

                        val top_albums = (response.body())!!
                        albums.addAll(top_albums.topalbums.album)
                        albumAdapter.notifyDataSetChanged()
                    }
                }


                override fun onFailure(call: Call<ArtistTopAlbums>, t: Throwable) {
                    Toast.makeText(this@ArtistDetailsActivity, "Failed $t", Toast.LENGTH_LONG).show()
                }

            })

    }

    private fun getArtistInfo() {
        val response = RetrofitInstance.api.getArtistInfo(artist)
        response.enqueue(
            object : retrofit2.Callback<ArtistInfoResponse> {
                override fun onResponse(
                    call: retrofit2.Call<ArtistInfoResponse>,
                    response: retrofit2.Response<ArtistInfoResponse>
                ) {
                    if (response.body() != null) {

                        val artist_info = (response.body())!!
                        tv_content.text=artist_info.artist.bio.content
                        tv_artist_followers.text="Followers: "+artist_info.artist.stats.listeners
                        tv_artist_playcount.text="Playcounts: "+artist_info.artist.stats.playcount
                    }
                }


                override fun onFailure(call: Call<ArtistInfoResponse>, t: Throwable) {
                    Toast.makeText(this@ArtistDetailsActivity, "Failed $t", Toast.LENGTH_LONG).show()
                }

            })

    }
}