package com.example.musicwiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.musicwiki.activity.GenreDetailsActivity
import com.example.musicwiki.api.RetrofitInstance
import com.example.musicwiki.model.Tag
import com.example.musicwiki.model.TopTagResponse
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var islistexpended: Boolean = false
    private lateinit var tagList: List<Tag>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val response = RetrofitInstance.api.getTopTags()
        response.enqueue(
            object : retrofit2.Callback<TopTagResponse>
            {
                override fun onResponse(call: retrofit2.Call<TopTagResponse>,response: retrofit2.Response<TopTagResponse>)
                {
                    if (response.body() != null)
                    {
                        val topTags = (response.body())!!
                        tagList = topTags.toptags.tag
                        refreshtheList()
                    }
                }
                override fun onFailure(call: retrofit2.Call<TopTagResponse>, t: Throwable)
                {
                    Toast.makeText(this@MainActivity, "Ativity started ${t}", Toast.LENGTH_LONG).show()
                }
            }
        )
    }
    private fun refreshtheList()
    {
        if (islistexpended) toggleIcon.setImageResource(R.drawable.ic_collapse)
        else toggleIcon.setImageResource(R.drawable.ic_expand)

        chipGroup.removeAllViews()
        for (i in 1 until tagList.size)
        {
            if (i == 10 && !islistexpended) break

            val tag = tagList[i]
            val chip = Chip(this)
            chip.text = tag.name

            chip.setChipBackgroundColorResource(R.color.white)

            chip.setOnClickListener {
                val intent = Intent(this,GenreDetailsActivity::class.java)
                intent.putExtra("tag", tag.name)
                startActivity(intent)
            }
            chipGroup.addView(chip)
        }
    }

    fun buttonPressed(view: View) {
        islistexpended = !islistexpended
        refreshtheList()
    }
}