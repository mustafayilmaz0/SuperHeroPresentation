package com.example.recyclerviewsuperhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val headingHeros: TextView = findViewById(R.id.heading)
        val mainHeros: TextView = findViewById(R.id.detail)
        val imageHeros: ImageView = findViewById(R.id.img_hero_detail)

        val bundle: Bundle? = intent.extras
        val heading = bundle!!.getString("heading")
        val imgHero = bundle.getInt("imgHero")
        val heros = bundle.getString("heros")

        headingHeros.text = heading
        mainHeros.text = heros
        imageHeros.setImageResource(imgHero)
    }
}