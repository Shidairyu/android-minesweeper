package ch.ost.rj.mge.android_minesweeper.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.android_minesweeper.R

class BoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val fieldIV: ImageView = itemView.findViewById(R.id.idIVField)
}