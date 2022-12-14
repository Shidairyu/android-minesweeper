package ch.ost.rj.mge.android_minesweeper.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HighscoreViewHolder(parent: View,
                          val rankingTextView: TextView,
                          val nameTextView: TextView,
                          val difficultyTextView: TextView,
                          val durationTextView: TextView,
                          ) :
    RecyclerView.ViewHolder(parent)