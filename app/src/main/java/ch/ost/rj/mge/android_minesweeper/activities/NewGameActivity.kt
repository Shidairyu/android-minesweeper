package ch.ost.rj.mge.android_minesweeper.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityNewGameBinding
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityStartScreenBinding

class NewGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = layoutInflater
        val binding = ActivityNewGameBinding.inflate(inflater)
        setContentView(binding.root)
    }
}