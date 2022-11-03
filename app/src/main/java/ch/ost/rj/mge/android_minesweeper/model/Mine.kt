package ch.ost.rj.mge.android_minesweeper.model

import ch.ost.rj.mge.android_minesweeper.R

data class Mine (
    override var pos: Position,
    ) : IField {

    override var isEnabled: Boolean = false
    override var bombValue: Int = 0
    override var fieldImage: Int = R.drawable.mine
}