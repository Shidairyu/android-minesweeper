package ch.ost.rj.mge.android_minesweeper.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.adapter.HelpViewPagerAdapter
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityHelpBinding

// TODO Finish Helper pages with descriptions and title
class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = layoutInflater
        val binding = ActivityHelpBinding.inflate(inflater)
        setContentView(binding.root)

        val helpViewPager = binding.helpViewpager

        val helpPageContents = resources.getStringArray(R.array.help_titles)
        val helpViewPagerAdapter = HelpViewPagerAdapter(this, helpPageContents.size)
        helpViewPager.adapter = helpViewPagerAdapter
    }
}