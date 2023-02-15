package com.example.musicwiki.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicwiki.R
import com.example.musicwiki.activity.ArtistDetailsActivity
import com.example.musicwiki.model.ArtistXXXXXX
import kotlinx.android.synthetic.main.artist_layout.view.*

class ArtistAdapter(
     val list: MutableList<ArtistXXXXXX>
): RecyclerView.Adapter<ArtistAdapter.ViewHolder>() {

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.artist_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artist=list[position]
        holder.itemView.name.text=artist.name
        val i = artist.image.size
        Glide.with(holder.itemView.image).load(artist.image[i-1].text).into(holder.itemView.image)

        holder.itemView.setOnClickListener()
        {
            val intent = Intent(holder.itemView.context, ArtistDetailsActivity::class.java)
            intent.putExtra("artist", artist.name)
            intent.putExtra("image", artist.image[i-1].text)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return  list.size
    }
}