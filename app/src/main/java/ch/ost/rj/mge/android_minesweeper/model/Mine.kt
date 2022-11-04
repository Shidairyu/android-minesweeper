package ch.ost.rj.mge.android_minesweeper.model

import ch.ost.rj.mge.android_minesweeper.R

data class Mine (
    override var pos: Position,
    ) : IField {

    override var bombValue: Int = 1
    override var fieldImage: Int = 0
    override var isFlagged: Boolean = false

    override var isEnabled: Boolean = false
        set(value) {
            field = value
            updateFieldImage()
        }

    override fun updateFieldImage() {
        fieldImage = R.drawable.mine
    }


}