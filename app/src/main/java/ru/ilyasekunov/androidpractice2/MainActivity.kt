package ru.ilyasekunov.androidpractice2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val heroesDataSet = listOf(
    Hero(
        picture = R.drawable.cyclops,
        name = R.string.cyclops
    ),
    Hero(
        picture = R.drawable.deadpool,
        name = R.string.deadpool
    ),
    Hero(
        picture = R.drawable.iron_man,
        name = R.string.iron_man
    ),
    Hero(
        picture = R.drawable.wolverine,
        name = R.string.wolverine
    ),
    Hero(
        picture = R.drawable.spider_man,
        name = R.string.spider_man
    ),
    Hero(
        picture = R.drawable.black_panther,
        name = R.string.black_panther
    ),
    Hero(
        picture = R.drawable.captain_america,
        name = R.string.captain_america
    )
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = HeroesViewAdapter(heroesDataSet)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}