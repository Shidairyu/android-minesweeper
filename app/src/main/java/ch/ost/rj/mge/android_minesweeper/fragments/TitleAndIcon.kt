package ch.ost.rj.mge.android_minesweeper.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ch.ost.rj.mge.android_minesweeper.BuildConfig
import ch.ost.rj.mge.android_minesweeper.R

class TitleAndIcon : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val versionText = view.findViewById<TextView>(R.id.version)
        versionText.text = buildString {
            append("Version ")
            append(BuildConfig.VERSION_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_title_and_icon, container, false)
    }
}
