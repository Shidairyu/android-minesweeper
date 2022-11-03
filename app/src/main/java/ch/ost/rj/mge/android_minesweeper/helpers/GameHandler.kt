package ch.ost.rj.mge.android_minesweeper.helpers

import ch.ost.rj.mge.android_minesweeper.model.IField
import ch.ost.rj.mge.android_minesweeper.model.Mine
import ch.ost.rj.mge.android_minesweeper.model.Position
import ch.ost.rj.mge.android_minesweeper.model.Value

class GameHandler(board: ArrayList<IField>) {
    val fieldWidth: Int = 10
    private val fieldHeight: Int = 10
    private var board: ArrayList<IField>
    private var bombCount: Int = 20

    init {
        this.board = board
    }

    fun setupGame() {
        initBoard()
        updateMineCounts()
    }

    private fun updateMineCounts() {
        for (field in board){
            if (field is Mine){
                var top = board.find { item -> item.pos.X == field.pos.X -1 && item.pos.Y == field.pos.Y}
                var bottom = board.find { item -> item.pos.X == field.pos.X +1 && item.pos.Y == field.pos.Y}
                var left = board.find { item -> item.pos.X == field.pos.X && item.pos.Y == field.pos.Y - 1}
                var right = board.find { item -> item.pos.X == field.pos.X && item.pos.Y == field.pos.Y + 1}
                var topleft = board.find { item -> item.pos.X == field.pos.X -1 && item.pos.Y == field.pos.Y -1}
                var topright = board.find { item -> item.pos.X == field.pos.X -1 && item.pos.Y == field.pos.Y + 1}
                var bottomleft = board.find { item -> item.pos.X == field.pos.X + 1 && item.pos.Y == field.pos.Y - 1}
                var bottomright = board.find { item -> item.pos.X == field.pos.X + 1 && item.pos.Y == field.pos.Y + 1}

                top?.let {  top.bombValue++ }
                bottom?.let {  bottom.bombValue++ }
                left?.let {  left.bombValue++ }
                right?.let {  right.bombValue++ }
                topleft?.let {  topleft.bombValue++ }
                topright?.let {  topright.bombValue++ }
                bottomleft?.let {  bottomleft.bombValue++ }
                bottomright?.let {  bottomright.bombValue++ }

            }
        }
    }

    private fun initBoard() {
        val mines: ArrayList<Position> = generateMines()

        for (i in 0 until fieldHeight) {
            for (j in 0 until fieldWidth) {
                if (isMine(i, j, mines)) {
                    board.add(Mine(Position(i, j)))
                } else {
                    board.add(Value(Position(i, j)))
                }
            }
        }
    }

    private fun isMine(i: Int, j: Int, mines: ArrayList<Position>): Boolean {
        for (mine in mines) if (mine.X == i && mine.Y == j) return true
        return false
    }

    private fun generateMines(): ArrayList<Position> {
        var tempList: ArrayList<Position> = ArrayList()
        while (tempList.size != bombCount){
            tempList.add(Position((0 until fieldHeight).random(),(0 until fieldWidth).random()))
        }
        return tempList
    }
}