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
                    FieldValue.Zero;
                }
                "one" -> {
                    FieldValue.One;
                }
                "two" -> {
                    FieldValue.Two;
                }
                "three" -> {
                    FieldValue.Three;
                }
                "four" -> {
                    FieldValue.Four;
                }
                "five" -> {
                    FieldValue.Five;
                }
                "six" -> {
                    FieldValue.Six;
                }
                "seven" -> {
                    FieldValue.Seven;
                }
                else ->{
                    FieldValue.Eight;
                }
            }
        }

        fun convertToInt(field : FieldValue) : Int{
            return field.value;
        }

        fun convertFromInt(value : Int) : FieldValue{
            return when (value) {
                R.drawable.zero -> {
                    FieldValue.Zero;
                }
                R.drawable.one -> {
                    FieldValue.One;
                }
                R.drawable.two -> {
                    FieldValue.Two;
                }
                R.drawable.three -> {
                    FieldValue.Three;
                }
                R.drawable.four -> {
                    FieldValue.Four;
                }
                R.drawable.five -> {
                    FieldValue.Five;
                }
                R.drawable.six -> {
                    FieldValue.Six;
                }
                R.drawable.seven -> {
                    FieldValue.Seven;
                }
                else -> {
                    FieldValue.Eight;
                }
            }
        }
    }
}