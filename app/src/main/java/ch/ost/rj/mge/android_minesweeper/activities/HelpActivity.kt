package ch.ost.rj.mge.android_minesweeper.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityHelpBinding
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityStartScreenBinding

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = layoutInflater
        val binding = ActivityHelpBinding.inflate(inflater)
        setContentView(binding.root)
    }
}