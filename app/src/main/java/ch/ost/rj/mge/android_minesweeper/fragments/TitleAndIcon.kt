package ch.ost.rj.mge.android_minesweeper.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.activities.HelpActivity

class TitleAndIcon : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_title_and_icon, container, false)
    }
}
