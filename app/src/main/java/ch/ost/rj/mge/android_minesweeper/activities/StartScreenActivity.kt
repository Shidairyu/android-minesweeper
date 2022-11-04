package ch.ost.rj.mge.android_minesweeper.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityStartScreenBinding
import ch.ost.rj.mge.android_minesweeper.fragments.StartControlsFragment
import ch.ost.rj.mge.android_minesweeper.fragments.TitleAndIcon

class StartScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace(binding.startControlsContainer.id, StartControlsFragment())
            replace(binding.titleIconContainer.id, TitleAndIcon())
            commit()
        }
    }
}