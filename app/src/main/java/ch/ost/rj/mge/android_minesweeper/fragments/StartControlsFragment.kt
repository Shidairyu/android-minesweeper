package ch.ost.rj.mge.android_minesweeper.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ch.ost.rj.mge.android_minesweeper.activities.HelpActivity
import ch.ost.rj.mge.android_minesweeper.activities.HighscoreActivity
import ch.ost.rj.mge.android_minesweeper.activities.LoadGameActivity
import ch.ost.rj.mge.android_minesweeper.activities.NewGameActivity
import ch.ost.rj.mge.android_minesweeper.databinding.FragmentStartControlsBinding

class StartControlsFragment : Fragment() {
    private var _binding : FragmentStartControlsBinding? = null;
    private val binding get() = _binding!!;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);

        setupButton(binding.loadGameButton, LoadGameActivity::class.java);
        setupButton(binding.newGameButton, NewGameActivity::class.java);
        setupButton(binding.highscoreButton, HighscoreActivity::class.java);
        setupButton(binding.helpButton, HelpActivity::class.java);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartControlsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun <T> setupButton(button: Button, classType: Class<T>){
        button.setOnClickListener {
            val intent = Intent(context, classType);
            startActivity(intent);
        }
    }
}