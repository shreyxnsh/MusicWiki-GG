package com.example.musicwiki.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicwiki.R
import com.example.musicwiki.activity.AlbumDetailsActivity
import com.example.musicwiki.model.AlbumXX
import kotlinx.android.synthetic.main.album_layout.view.*

class AlbumAdapter(
    val list: MutableList<AlbumXX>
) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.album_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val album=list[position]
        holder.itemView.title.text=album.name
        holder.itemView.artist.text=album.artist.name
        val i = album.image.size
        Glide.with(holder.itemView.image).load(album.image[i-1].text).into(holder.itemView.image)
        holder.itemView.setOnClickListener()
        {
            val intent = Intent(holder.itemView.context,AlbumDetailsActivity::class.java)
            intent.putExtra("album_name", album.name)
            intent.putExtra("artist", album.artist.name)
            intent.putExtra("image", album.image[i-1].text)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return  list.size
    }
}