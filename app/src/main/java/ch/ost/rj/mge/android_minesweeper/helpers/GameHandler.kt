package ch.ost.rj.mge.android_minesweeper.helpers

import ch.ost.rj.mge.android_minesweeper.model.IField
import ch.ost.rj.mge.android_minesweeper.model.Mine
import ch.ost.rj.mge.android_minesweeper.model.Position
import ch.ost.rj.mge.android_minesweeper.model.Value

class GameHandler(board: ArrayList<IField>) {
    val fieldWidth: Int = 10
    private val fieldHeight: Int = 15
    private var board: ArrayList<IField>
    private var bombCount: Int = 20

    init {
        this.board = board
    }

    fun setupGame() {
        val bombs: ArrayList<Position> = generateBombs()

        for (i in 0 until  fieldHeight){
            for (j in 0 until fieldWidth){
                board.add(Value(Position(i,j),0))
            }
        }
    }

    private fun generateBombs(): ArrayList<Position> {
        var tempList: ArrayList<Position> = ArrayList()
        for (i in 0 until bombCount){
            tempList.add(Position((0 until fieldHeight).random(),(0 until fieldWidth).random()))
        }
        return tempList
    }
}