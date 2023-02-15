package com.example.musicwiki.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicwiki.R
import com.example.musicwiki.model.TrackX
import kotlinx.android.synthetic.main.album_layout.view.*

class ArtistTrackAdapter(
    val list: MutableList<TrackX>
) : RecyclerView.Adapter<ArtistTrackAdapter.ViewHolder>() {

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.artist_album_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val tracks=list[position]
        holder.itemView.title.text=tracks.name
        val i = tracks.image.size
        Glide.with(holder.itemView.image).load(tracks.image[i-1].text).into(holder.itemView.image)

    }

    override fun getItemCount(): Int {
        return  list.size
    }
}