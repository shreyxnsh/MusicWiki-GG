package com.example.musicwiki.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicwiki.R
import com.example.musicwiki.adapter.AlbumAdapter
import com.example.musicwiki.adapter.ArtistAdapter
import com.example.musicwiki.adapter.TrackAdapter
import com.example.musicwiki.api.RetrofitInstance
import com.example.musicwiki.model.*
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_genre_details.*
import retrofit2.Call

class GenreDetailsActivity : AppCompatActivity() {

    lateinit var tagName: String

    var albums: MutableList<AlbumXX> = mutableListOf()
    var artists: MutableList<ArtistXXXXXX> = mutableListOf()
    var tracks: MutableList<TrackXX> = mutableListOf()
    val albumAdapter: AlbumAdapter = AlbumAdapter(albums)
    var artistAdapter: ArtistAdapter = ArtistAdapter(artists)
    var trackAdapter: TrackAdapter = TrackAdapter(tracks)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre_details)

        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = albumAdapter
        tagName = intent.getStringExtra("tag")!!


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab!!.text!!.equals("ALBUMS")) {
                    recyclerView.adapter = albumAdapter
                } else if (tab.text!!.equals("ARTISTS")) {
                    recyclerView.adapter = artistAdapter
                } else if (tab.text!!.equals("TRACKS")) {
                    recyclerView.adapter = trackAdapter
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })



        getTagInfo()
        getTopAlbums()
        getTopArtists()
        getTopTracks()
    }

    private fun getTopTracks() {
        val response = RetrofitInstance.api.getTagTracks(tagName)
        response.enqueue(
            object : retrofit2.Callback<TagTrackResponse> {
                override fun onResponse(
                    call: retrofit2.Call<TagTrackResponse>,
                    response: retrofit2.Response<TagTrackResponse>
                ) {
                    if (response.body() != null) {

                        val topTrackResponse = (response.body())!!
                        tracks.addAll(topTrackResponse.tracks.track)
                        trackAdapter.notifyDataSetChanged()


                    }
                }


                override fun onFailure(call: Call<TagTrackResponse>, t: Throwable) {

                }

            },
        )
    }

    private fun getTopArtists() {

        val response = RetrofitInstance.api.getTagArtists(tagName)
        response.enqueue(
            object : retrofit2.Callback<TagArtistResponse> {
                override fun onResponse(
                    call: retrofit2.Call<TagArtistResponse>,
                    response: retrofit2.Response<TagArtistResponse>
                ) {
                    if (response.body() != null) {
                        val topArtistResponse = (response.body())!!
                        artists.addAll(topArtistResponse.topartists.artist)
                        artistAdapter.notifyDataSetChanged()


                    }
                }


                override fun onFailure(call: Call<TagArtistResponse>, t: Throwable) {
                    Toast.makeText(this@GenreDetailsActivity, "Failed $t", Toast.LENGTH_LONG).show()
                }

            },
        )
    }

    private fun getTopAlbums() {
        val response = RetrofitInstance.api.getTagTopAlbums(tagName)
        response.enqueue(
            object : retrofit2.Callback<TagAlbumResponse> {
                override fun onResponse(
                    call: retrofit2.Call<TagAlbumResponse>,
                    response: retrofit2.Response<TagAlbumResponse>
                ) {
                    if (response.body() != null) {

                        val topAlbumResponse = (response.body())!!
                        albums.addAll(topAlbumResponse.albums.album)
                        albumAdapter.notifyDataSetChanged()


                    }
                }


                override fun onFailure(call: Call<TagAlbumResponse>, t: Throwable) {
                    Toast.makeText(this@GenreDetailsActivity, "Failed $t", Toast.LENGTH_LONG).show()
                }

            },
        )

    }

    private fun getTagInfo() {


        val response = RetrofitInstance.api.getTagInfo(tagName)
        response.enqueue(
            object : retrofit2.Callback<TagInfoResponse> {
                override fun onResponse(
                    call: retrofit2.Call<TagInfoResponse>,
                    response: retrofit2.Response<TagInfoResponse>
                ) {
                    if (response.body() != null) {

                        val taginfo = (response.body())!!
                        tagDescription.text = taginfo.tag.wiki.summary
                        tagTitle.text = taginfo.tag.name
                    }
                }


                override fun onFailure(call: Call<TagInfoResponse>, t: Throwable) {
                    Toast.makeText(this@GenreDetailsActivity, "Failed $t", Toast.LENGTH_LONG).show()
                }

            })

    }
}