package com.example.musicwiki.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.musicwiki.R
import com.example.musicwiki.adapter.TagAdapter
import com.example.musicwiki.api.RetrofitInstance
import com.example.musicwiki.model.AlbumDetailsResponse
import com.example.musicwiki.model.TagXX
import kotlinx.android.synthetic.main.activity_album_details.*
import retrofit2.Call

class AlbumDetailsActivity : AppCompatActivity() {

    lateinit var album_name: String
    lateinit var artist: String
    lateinit var image: String
    var tags:MutableList<TagXX> = mutableListOf()
    var adapter:TagAdapter= TagAdapter(tags)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_details)

        album_name = intent.getStringExtra("album_name")!!
        artist = intent.getStringExtra("artist")!!
        image = intent.getStringExtra("image")!!
        tv_album_name.text=album_name
        tv_album_artist.text=artist
        rv_album_tags.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rv_album_tags.adapter=adapter
        getAlbumInfo()
    }

    private fun getAlbumInfo() {


        val response = RetrofitInstance.api.getAlbumInfo(artist,album_name)
        response.enqueue(
            object : retrofit2.Callback<AlbumDetailsResponse> {
                override fun onResponse(
                    call: retrofit2.Call<AlbumDetailsResponse>,
                    response: retrofit2.Response<AlbumDetailsResponse>
                ) {
                    if (response.body() != null) {

                        val album_info = (response.body())!!
                        tv_play_count.text="Playcount: "+album_info.album.playcount
                        tv_album_wiki.text= album_info.album.wiki?.content
                        val i=album_info.album.image.size
                        Glide.with(iv_album_img).load(image).into(iv_album_img)
                        tags.addAll(album_info.album.tags.tag)
                        adapter.notifyDataSetChanged()
                    }
                }


                override fun onFailure(call: Call<AlbumDetailsResponse>, t: Throwable) {
                    Toast.makeText(this@AlbumDetailsActivity, "Failed $t", Toast.LENGTH_LONG).show()
                }

            })

    }
}