package ch.ost.rj.mge.android_minesweeper.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.android_minesweeper.adapter.BoardAdapter
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityGameBinding
import ch.ost.rj.mge.android_minesweeper.helpers.Difficulty
import ch.ost.rj.mge.android_minesweeper.helpers.GameHandler
import ch.ost.rj.mge.android_minesweeper.helpers.SharedData
import ch.ost.rj.mge.android_minesweeper.model.IField

class GameActivity : AppCompatActivity() {
    private lateinit var boardRV: RecyclerView
    private lateinit var bombCountTV: TextView
    private lateinit var boardAdapter: BoardAdapter
    private lateinit var board: ArrayList<IField>
    private lateinit var gameHandler: GameHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val difficulty = Difficulty.fromString(intent.getStringExtra(SharedData.DifficultyKey)!!)
        val username = intent.getStringExtra(SharedData.UsernameKey)

        boardRV = binding.idRVBoard
        board = ArrayList()
        gameHandler = GameHandler(board, difficulty)

        bombCountTV = binding.idTVBombCount
        bombCountTV.text = gameHandler.bombCount.toString()

        val layoutManager = GridLayoutManager(this, gameHandler.fieldWidth)
        boardRV.layoutManager = layoutManager

        boardAdapter = BoardAdapter(board, this)
        boardRV.adapter = boardAdapter

        gameHandler.setupGame()

        boardAdapter.notifyDataSetChanged()
    }
    fun onClickBoard(field: IField) {
        gameHandler.onClickBoard(field)
        boardAdapter.notifyDataSetChanged()
    }

    fun onLongClickBoard(field: IField) {
        gameHandler.onLongClickBoard(field)
        boardAdapter.notifyDataSetChanged()
        bombCountTV.text = gameHandler.bombCount.toString()
    }
}
