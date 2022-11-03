package ch.ost.rj.mge.android_minesweeper.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.android_minesweeper.R

class BoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val courseNameTV: TextView = itemView.findViewById(R.id.idTVCourse)
    val courseIV: ImageView = itemView.findViewById(R.id.idIVCourse)
}