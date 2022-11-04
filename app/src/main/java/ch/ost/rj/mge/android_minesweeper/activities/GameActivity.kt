package ch.ost.rj.mge.android_minesweeper.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.adapter.BoardAdapter
import ch.ost.rj.mge.android_minesweeper.helpers.Difficulty
import ch.ost.rj.mge.android_minesweeper.helpers.GameHandler
import ch.ost.rj.mge.android_minesweeper.model.IField

class GameActivity : AppCompatActivity() {
    private val USERNAME_KEY = "username"
    private val DIFFICULTY_KEY = "difficulty"

    lateinit var boardRV: RecyclerView
    lateinit var boardAdapter: BoardAdapter
    lateinit var board: ArrayList<IField>
    lateinit var gameHandler: GameHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val difficulty = intent.getStringExtra(DIFFICULTY_KEY)?.let { Difficulty.fromString(it) };
        val username = intent.getStringExtra(USERNAME_KEY)

        boardRV = findViewById(R.id.idRVBoard)
        board = ArrayList()
        gameHandler = GameHandler(board)

        val layoutManager = GridLayoutManager(this, gameHandler.fieldWidth)
        boardRV.layoutManager = layoutManager

        boardAdapter = BoardAdapter(board, this)
        boardRV.adapter = boardAdapter

        gameHandler.setupGame()

        boardAdapter.notifyDataSetChanged()
    }
}
