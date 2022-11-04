package ch.ost.rj.mge.android_minesweeper.helpers

enum class Difficulty(val value : Int){
    Hard(60),
    Normal(40),
    Easy(20);

    companion object {
        fun convertToInt(difficulty : Difficulty) : Int{
            return difficulty.value
        }

        fun convertFromInt(value : Int) : Difficulty{
            return when (value) {
                Hard.value -> {
                    Hard
                }
                Easy.value -> {
                    Easy
                }
                else -> {
                    Normal
                }
            }
        }

        fun fromString(string : String): Difficulty {
            return when (string) {
                "hard" -> {
                    Hard
                }
                "easy" -> {
                    Easy
                }
                else -> {
                    Normal
                }
            }
        }
    }

    override fun toString(): String {
        return when (this) {
            Hard -> {
                "hard"
            }
            Easy -> {
                "easy"
            }
            else -> {
                "normal"
            }
        }
    }
}