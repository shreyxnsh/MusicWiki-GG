package com.example.musicwiki.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.activity.GenreDetailsActivity
import com.example.musicwiki.model.TagXX
import kotlinx.android.synthetic.main.tag_name_layout.view.*

class TagAdapter(val list:MutableList<TagXX>): RecyclerView.Adapter<TagAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.tag_name_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_tag_name.text=list[position].name

        holder.itemView.setOnClickListener{
            var context:Context=holder.itemView.context
            val intent = Intent(context, GenreDetailsActivity::class.java)
            intent.putExtra("tag", list[position].name)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}