package ch.ost.rj.mge.android_minesweeper.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ch.ost.rj.mge.android_minesweeper.R
/**
 * A simple [Fragment] subclass.
 * Use the [StartControlsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StartControlsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_controls, container, false)
    }
}