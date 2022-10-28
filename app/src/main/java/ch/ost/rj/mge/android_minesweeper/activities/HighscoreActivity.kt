package ch.ost.rj.mge.android_minesweeper.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.adapter.HighscoreAdapter
import ch.ost.rj.mge.android_minesweeper.model.HighscoreRepository

class HighscoreActivity() : AppCompatActivity() {
    private var adapter: HighscoreAdapter = HighscoreAdapter();
    private var highscoreRepository : HighscoreRepository? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        val context = applicationContext
        highscoreRepository = HighscoreRepository.initialize(context);

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_highscore)

        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val recyclerView = findViewById<RecyclerView>(R.id.highscore_view)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = adapter;
        recyclerView.addItemDecoration(dividerItemDecoration)
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