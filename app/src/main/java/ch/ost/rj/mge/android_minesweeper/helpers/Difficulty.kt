package ch.ost.rj.mge.android_minesweeper.helpers

enum class Difficulty(val value : Int){
    Hard(8),
    Normal(16),
    Easy(32);

    companion object {
        fun parse(difficulty: String) : Difficulty{
            return when (difficulty.lowercase()) {
                "hard" -> {
                    Difficulty.Hard;
                }
                "easy" -> {
                    Difficulty.Easy;
                }
                else -> {
                    Difficulty.Normal;
                }
            }
        }

        fun convertToInt(difficulty : Difficulty) : Int{
            return difficulty.value;
        }

        fun convertFromInt(value : Int) : Difficulty{
            return when (value) {
                8 -> {
                    Difficulty.Hard;
                }
                16 -> {
                    Difficulty.Easy;
                }
                else -> {
                    Difficulty.Normal;
                }
            }
        }
    }
}