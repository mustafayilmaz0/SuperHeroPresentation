package com.example.recyclerviewsuperhero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Hero>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var heros: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.aquaman,
            R.drawable.batman,
            R.drawable.fastman,
            R.drawable.ironman,
            R.drawable.logan,
            R.drawable.neo,
            R.drawable.spiderman,
            R.drawable.superman,
            R.drawable.thor
        )

        heading = arrayOf(
            "lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore lorem ipsum dolor sit amet consectetur ",
            "ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore lorem ipsum dolor sit amet consectetur adipiscing",
            "dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore lorem ipsum dolor sit amet consectetur adipiscing elit ",
            "sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore lorem ipsum dolor sit amet consectetur adipiscing elit sed ",
            "amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore lorem ipsum dolor sit amet consectetur adipiscing elit sed do ",
            "consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore lorem ipsum dolor sit amet consectetur adipiscing elit sed do ",
            "adipiscing elit sed do eiusmod tempor incididunt ut laborelorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor ",
            "elit sed do eiusmod tempor incididunt ut labore lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut ",
            "sed do eiusmod tempor incididunt ut labore lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore"
        )

        heros = arrayOf(
            getString(R.string.str_aquaman_info),
            getString(R.string.str_batman_info),
            getString(R.string.str_fastman_info),
            getString(R.string.str_ironman_info),
            getString(R.string.str_logan_info),
            getString(R.string.str_neo_info),
            getString(R.string.str_spiderman_info),
            getString(R.string.str_superman_info),
            getString(R.string.str_thor_info)
        )

        newRecyclerView = findViewById(R.id.recycler_view)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<Hero>()
        getUserData()
    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val hero = Hero(imageId[i], heading[i])
            newArrayList.add(hero)
        }

        val adapter = RecyclerAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnClickListener(object : RecyclerAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                // Toast.makeText(this@MainActivity, "You clicked on item no. $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("heading", newArrayList[position].textHeroHeading)
                intent.putExtra("imgHero", newArrayList[position].imgHero)
                intent.putExtra("heros", heros[position])
                startActivity(intent)
            }
        })
    }
}