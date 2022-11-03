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
import ch.ost.rj.mge.android_minesweeper.activities.HighscoreActivity
import ch.ost.rj.mge.android_minesweeper.activities.GameActivity

class StartControlsFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);
        val loadGameButton = view.findViewById<Button>(R.id.loadGame_button);
        val newGameButton = view.findViewById<Button>(R.id.newGame_button);
        val highscoreButton = view.findViewById<Button>(R.id.highscore_button);
        val helpButton = view.findViewById<Button>(R.id.help_button);

        setupButton(loadGameButton, GameActivity::class.java);
        setupButton(newGameButton, GameActivity::class.java);
        setupButton(highscoreButton, HighscoreActivity::class.java);
        setupButton(helpButton, HelpActivity::class.java);
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_controls, container, false)
    }

    private fun <T> setupButton(button: Button, classType: Class<T>){
        button.setOnClickListener {
            val intent = Intent(context, classType);
            startActivity(intent);
        }
    }
}