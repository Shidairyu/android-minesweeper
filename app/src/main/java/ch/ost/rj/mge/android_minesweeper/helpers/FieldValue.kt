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
        fun convertToInt(field : FieldValue) : Int{
            return field.value
        }
    }
}