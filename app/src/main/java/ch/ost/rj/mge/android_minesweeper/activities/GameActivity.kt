package ch.ost.rj.mge.android_minesweeper.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
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
import ch.ost.rj.mge.android_minesweeper.helpers.TimerService
import ch.ost.rj.mge.android_minesweeper.model.IField
import kotlin.math.roundToInt

class GameActivity : AppCompatActivity() {
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
        setupTimer()
        startTimer()

        boardAdapter.notifyDataSetChanged()
    }

    private fun startTimer() {
        serviceIntent.putExtra(TimerService.TIME_EXTRA,time)
        startService(serviceIntent)

    }

    private fun setupTimer() {
        serviceIntent = Intent(applicationContext, TimerService::class.java)
        registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
    }

    private val updateTime: BroadcastReceiver = object : BroadcastReceiver (){
        override fun onReceive(context: Context?, intent: Intent) {
            time = intent.getDoubleExtra(TimerService.TIME_EXTRA,0.0)
            binding.idTVTimer.text = getTimeStringFromDouble(time)
        }
    }

    private fun getTimeStringFromDouble(time:Double) : String {
        val resultInt = time.roundToInt()
        val hours = resultInt % 86400 / 3600
        val minutes = resultInt % 86400 % 3600 / 60
        val seconds = resultInt % 86400 % 3600 % 60
        return makeTimeString(hours,minutes,seconds)
    }

    private fun makeTimeString(hours: Int, minutes: Int, seconds: Int): String = String.format("%02d:%02d:%02d", hours, minutes, seconds)

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
