package ch.ost.rj.mge.android_minesweeper.model
import ch.ost.rj.mge.android_minesweeper.R
import ch.ost.rj.mge.android_minesweeper.helpers.FieldValue
import ch.ost.rj.mge.android_minesweeper.helpers.FieldValue.Companion.convertToInt

data class Value(
    override var pos: Position,
    ) : IField {

    override var fieldImage: Int = 0
    override var isEnabled: Boolean = false
        set(value) {
            field = value
            updateFieldImage()
        }
    override var bombValue: Int = 0
        set(value) {
            field = value
            updateFieldImage()
        }
    override var isFlagged: Boolean = false

    override fun updateFieldImage() {
        if (isEnabled){
            fieldImage = when(bombValue){
                0 -> convertToInt(FieldValue.Zero)
                1 -> convertToInt(FieldValue.One)
                2 -> convertToInt(FieldValue.Two)
                3 -> convertToInt(FieldValue.Three)
                4 -> convertToInt(FieldValue.Four)
                5 -> convertToInt(FieldValue.Five)
                6 -> convertToInt(FieldValue.Six)
                7 -> convertToInt(FieldValue.Seven)
                else -> convertToInt(FieldValue.Eight)
            }
        }
    }
}