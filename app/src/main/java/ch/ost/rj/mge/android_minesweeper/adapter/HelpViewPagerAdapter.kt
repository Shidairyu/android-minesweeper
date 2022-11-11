package ch.ost.rj.mge.android_minesweeper.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import ch.ost.rj.mge.android_minesweeper.fragments.HelpFragment

class HelpViewPagerAdapter(activity: AppCompatActivity, private val itemsCount: Int) :
FragmentStateAdapter(activity)  {
    override fun getItemCount(): Int {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        return HelpFragment.getInstance(position)
    }
}

