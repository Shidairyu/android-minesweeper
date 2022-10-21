package ch.ost.rj.mge.android_minesweeper.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.fragments.StartControlsFragment
import ch.ost.rj.mge.android_minesweeper.fragments.TitleAndIcon

class StartScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        val titleAndIconFragment = TitleAndIcon();
        val startControlsFragment = StartControlsFragment();

        supportFragmentManager
            .beginTransaction()
            .add(R.id.title_icon_container, titleAndIconFragment)
            .add(R.id.start_controls_container, startControlsFragment)
            .commit();
    }
}