package ch.ost.rj.mge.android_minesweeper.model

import ch.ost.rj.mge.android_minesweeper.R

data class Value(
    override var pos: Position,
    override var bombValue: Int
    ) : IField {

    override var fieldImage: Int = R.drawable.number
    override var isEnabled: Boolean = false

    init {
        fieldImage = R.drawable.number
    }
}