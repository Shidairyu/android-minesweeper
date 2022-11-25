package ch.ost.rj.mge.android_minesweeper.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.adapter.HelpViewPagerAdapter
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityHelpBinding

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = layoutInflater
        val binding = ActivityHelpBinding.inflate(inflater)
        setContentView(binding.root)

        val helpViewPager = findViewById<ViewPager2>(R.id.help_viewpager)

        val helpPageContents = resources.getStringArray(R.array.help_titles)
        val helpViewPagerAdapter = HelpViewPagerAdapter(this, helpPageContents.size)
        helpViewPager.adapter = helpViewPagerAdapter
    }
}