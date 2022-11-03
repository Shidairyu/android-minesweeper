package ch.ost.rj.mge.android_minesweeper.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.model.IField

class BoardAdapter(
    private val board: ArrayList<IField>,
    private val context: Context
) : RecyclerView.Adapter<BoardViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BoardViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.fragment_board_item,
            parent, false
        )
        return BoardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.courseNameTV.text = board[position].pos.X.toString() + " / " + board[position].pos.Y.toString()
        holder.courseIV.setImageResource(board[position].fieldImage)
    }

    override fun getItemCount(): Int {
        return board.size
    }
}
