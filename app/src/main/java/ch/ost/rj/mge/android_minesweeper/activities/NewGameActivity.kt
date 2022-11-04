package ch.ost.rj.mge.android_minesweeper.activities

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.android_minesweeper.databinding.ActivityNewGameBinding
import ch.ost.rj.mge.android_minesweeper.helpers.Difficulty

class NewGameActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewGameBinding
    private var radioButtonsChecked = false
    private var usernameInputCheck = false
    private var difficulty = Difficulty.Normal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.difficulty.setOnCheckedChangeListener { _, checkedId ->
            difficulty = if (binding.difficultyHard.id == checkedId){
                Difficulty.Hard
            } else if (binding.difficultyEasy.id == checkedId){
                Difficulty.Easy
            } else {
                Difficulty.Normal
            }

            radioButtonsChecked = true
            if(usernameInputCheck){
                activateStartButton(difficulty)
            }
        }

        binding.newGameUsernameInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                val username: String = binding.newGameUsernameInput.text.toString()
                if(username.isNotEmpty()){
                    usernameInputCheck = true
                } else {
                    usernameInputCheck = false;
                    binding.startNewGame.isEnabled = false;
                }

                if(usernameInputCheck && radioButtonsChecked){
                    activateStartButton(difficulty)
                }
            }
        })

        binding.newGameHelp.setOnClickListener{
            val intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }
    }

    fun activateStartButton(difficulty : Difficulty){
        binding.startNewGame.setOnClickListener{
            intent.putExtra("difficulty", difficulty.toString())
            intent.putExtra("username", binding.newGameUsernameInput.text.toString())

            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
        binding.startNewGame.isEnabled = true;
    }
}