package ch.ost.rj.mge.android_minesweeper.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.adapter.HighscoreAdapter
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityHighscoreBinding
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityStartScreenBinding
import ch.ost.rj.mge.android_minesweeper.model.HighscoreRepository

class HighscoreActivity() : AppCompatActivity() {
    private var adapter: HighscoreAdapter = HighscoreAdapter();
    private var highscoreRepository : HighscoreRepository? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        val context = applicationContext
        highscoreRepository = HighscoreRepository.initialize(context);

        super.onCreate(savedInstanceState)

        val inflater = layoutInflater
        val binding = ActivityHighscoreBinding.inflate(inflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.highscoreView.layoutManager = layoutManager

        binding.highscoreView.adapter = adapter;
        binding.highscoreView.addItemDecoration(dividerItemDecoration)
    }

    override fun onResume() {
        super.onResume()
        val highscores = highscoreRepository?.getHighscores()

        if(highscores == null){
            Toast.makeText(
                applicationContext,
                "Connection to database was not established correctly",
                Toast.LENGTH_LONG).show();
        } else {
            adapter.updateHighscores(highscores)
        }
    }
}