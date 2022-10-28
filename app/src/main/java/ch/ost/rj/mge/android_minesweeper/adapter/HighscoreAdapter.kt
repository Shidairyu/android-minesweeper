package ch.ost.rj.mge.android_minesweeper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.android_minesweeper.model.Highscore

class HighscoreAdapter : RecyclerView.Adapter<HighscoreViewHolder>() {
    private var highscores = listOf<Highscore>()

    fun updateHighscores(scores: List<Highscore>) {
        highscores = scores.sorted()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighscoreViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(
            android.R.layout.simple_list_item_2,
            parent,
            false
        )

        val textView = view.findViewById<TextView>(android.R.id.text1)
        return HighscoreViewHolder(view, textView)
    }

    override fun onBindViewHolder(holder: HighscoreViewHolder, position: Int) {
        holder.highscoreTextView.text = buildString {
            append(position + 1)
            append(": ")
            append(highscores[position])
        }
    }

    override fun getItemCount(): Int {
        return highscores.size
    }
}





