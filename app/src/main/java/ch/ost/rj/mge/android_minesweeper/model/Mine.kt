package ch.ost.rj.mge.android_minesweeper.model

import ch.ost.rj.mge.android_minesweeper.R

data class Mine (
    override var pos: Position,
    override var bombValue: Int
    ) : IField {

    override var isEnabled: Boolean = false
    override var fieldImage: Int = R.drawable.mine
}