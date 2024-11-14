package ru.ilyasekunov.androidpractice2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView

data class Hero(
    @DrawableRes
    val picture: Int,
    @StringRes
    val name: Int
)

class HeroesViewAdapter(
    private val heroes: List<Hero>
) : RecyclerView.Adapter<HeroesViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(heroes[position].picture)
        holder.textView.setText(heroes[position].name)
    }

    override fun getItemCount() = heroes.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val textView: TextView = view.findViewById(R.id.textView)
    }
}