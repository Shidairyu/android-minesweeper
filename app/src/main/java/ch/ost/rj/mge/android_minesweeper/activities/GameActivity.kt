package ch.ost.rj.mge.android_minesweeper.activities

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.android_minesweeper.adapter.BoardAdapter
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityGameBinding
import ch.ost.rj.mge.android_minesweeper.helpers.Difficulty
import ch.ost.rj.mge.android_minesweeper.helpers.GameHandler
import ch.ost.rj.mge.android_minesweeper.helpers.SharedData
import ch.ost.rj.mge.android_minesweeper.helpers.TimerService
import ch.ost.rj.mge.android_minesweeper.model.Highscore
import ch.ost.rj.mge.android_minesweeper.model.HighscoreRepository
import ch.ost.rj.mge.android_minesweeper.model.IField

class GameActivity : AppCompatActivity() {
    private lateinit var username: String
    private lateinit var difficulty: Difficulty
    private lateinit var binding: ActivityGameBinding
    private lateinit var boardRV: RecyclerView
    private lateinit var bombCountTV: TextView
    private lateinit var boardAdapter: BoardAdapter
    private lateinit var board: ArrayList<IField>
    private lateinit var gameHandler: GameHandler
    private lateinit var serviceIntent: Intent
    private var time = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        difficulty = Difficulty.fromString(intent.getStringExtra(SharedData.DifficultyKey)!!)
        username = intent.getStringExtra(SharedData.UsernameKey)!!

        boardRV = binding.idRVBoard
        board = ArrayList()
        startTimer()
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

    private fun startTimer() {
        serviceIntent = Intent(applicationContext, TimerService::class.java)
        registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
        serviceIntent.putExtra(TimerService.TIME_EXTRA,time)
        startService(serviceIntent)
    }

    private val updateTime: BroadcastReceiver = object : BroadcastReceiver (){
        override fun onReceive(context: Context?, intent: Intent) {
            time = intent.getDoubleExtra(TimerService.TIME_EXTRA,0.0)
            binding.idTVTimer.text = TimerService.getTimeStringFromDouble(time)
        }
    }

    private fun showEndToast(isWin: Boolean) {
        val msg = if (isWin){
            "Congratulations, you have successfully completed the minesweeper game\nPlease check the Highscore-Board:)"
        } else {
            "Oops, looks like you failed to solve the game. Please try again."
        }
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Game Over")
        builder.setMessage(msg)
        builder.setPositiveButton("OK",) { _, _ ->
            goBackToMainScreen()
        }
        builder.show()
    }

    private fun goBackToMainScreen() {
        endTimer()
        val intent = Intent(applicationContext, StartScreenActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }

    private fun endTimer() {
        stopService(serviceIntent)
    }

    fun onClickBoard(field: IField) {
        gameHandler.onClickBoard(field) { isWin -> endgameCallback(isWin)}
        boardAdapter.notifyDataSetChanged()
    }

    private fun endgameCallback(isWin: Boolean) {
        if (isWin) {
            val duration = TimerService.getTimeStringFromDouble(time)
            val highscore = Highscore(username, difficulty, duration)
            val highscoreRepository = HighscoreRepository.initialize(applicationContext)
            highscoreRepository.addHighscore(highscore)
            showEndToast(true)
        } else {
            showEndToast(false)
        }
    }

    fun onLongClickBoard(field: IField) {
        gameHandler.onLongClickBoard(field) { isWin -> endgameCallback(isWin)}
        boardAdapter.notifyDataSetChanged()
        bombCountTV.text = gameHandler.bombCount.toString()
    }
}
