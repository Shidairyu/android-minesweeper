package ch.ost.rj.mge.android_minesweeper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.android_minesweeper.databinding.HighscoreViewBinding
import ch.ost.rj.mge.android_minesweeper.model.Highscore

class HighscoreAdapter : RecyclerView.Adapter<HighscoreViewHolder>() {
    private var highscores = listOf<Highscore>()

    fun updateHighscores(scores: List<Highscore>) {
        highscores = scores.sorted()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighscoreViewHolder {
        val context = parent.context
        val binding = HighscoreViewBinding.inflate(LayoutInflater.from(context), parent, false)

        val rankingTextView = binding.ranking
        val nameTextView = binding.name
        val durationTextView = binding.difficulty
        val difficultyTextView = binding.duration
        return HighscoreViewHolder(binding.root,
            rankingTextView,
            nameTextView,
            durationTextView,
            difficultyTextView)
    }

    override fun getItemCount(): Int {
        return highscores.size
    }

    override fun onBindViewHolder(holder: HighscoreViewHolder, position: Int) {
        val score = highscores[position]
        holder.rankingTextView.text = "${position+1}."
        holder.nameTextView.text = score.username
        holder.difficultyTextView.text = score.difficulty.toString()
        holder.durationTextView.text = score.durationInSeconds.toString()
    }
}





