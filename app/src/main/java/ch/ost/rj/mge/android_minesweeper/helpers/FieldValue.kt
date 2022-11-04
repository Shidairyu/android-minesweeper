package ch.ost.rj.mge.android_minesweeper.helpers

import ch.ost.rj.mge.android_minesweeper.R

enum class FieldValue(val value : Int) {
    Zero(R.drawable.zero),
    One(R.drawable.one),
    Two(R.drawable.two),
    Three(R.drawable.three),
    Four(R.drawable.four),
    Five(R.drawable.five),
    Six(R.drawable.six),
    Seven(R.drawable.seven),
    Eight(R.drawable.eight);

    companion object {
        fun parse(fieldNum: String) : FieldValue{
            return when (fieldNum.lowercase()) {
                "zero" -> {
                    Zero
                }
                "one" -> {
                    One
                }
                "two" -> {
                    Two
                }
                "three" -> {
                    Three
                }
                "four" -> {
                    Four
                }
                "five" -> {
                    Five
                }
                "six" -> {
                    Six
                }
                "seven" -> {
                    Seven
                }
                else ->{
                    Eight
                }
            }
        }

        fun convertToInt(field : FieldValue) : Int{
            return field.value
        }

        fun convertFromInt(value : Int) : FieldValue{
            return when (value) {
                R.drawable.zero -> {
                    Zero
                }
                R.drawable.one -> {
                    One
                }
                R.drawable.two -> {
                    Two
                }
                R.drawable.three -> {
                    Three
                }
                R.drawable.four -> {
                    Four
                }
                R.drawable.five -> {
                    Five
                }
                R.drawable.six -> {
                    Six
                }
                R.drawable.seven -> {
                    Seven
                }
                else -> {
                    Eight
                }
            }
        }
    }
}