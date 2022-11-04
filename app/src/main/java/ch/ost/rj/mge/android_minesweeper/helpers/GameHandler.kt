package ch.ost.rj.mge.android_minesweeper.helpers

import ch.ost.rj.mge.android_minesweeper.model.IField
import ch.ost.rj.mge.android_minesweeper.model.Mine
import ch.ost.rj.mge.android_minesweeper.model.Position
import ch.ost.rj.mge.android_minesweeper.model.Value
import java.util.Timer

class GameHandler(board: ArrayList<IField>, difficulty: Difficulty) {
    val fieldWidth: Int = 10
    private val fieldHeight: Int = 20
    private var board: ArrayList<IField>
    var bombCount: Int = 0
    private var enablingFields: ArrayList<IField> = ArrayList()

    init {
        bombCount = difficulty.value
        this.board = board
    }

    fun setupGame() {
        initBoard()
        updateMineCounts()
        startTimer()
    }

    private fun startTimer() {
        //Implement Timer
    }

    private fun updateMineCounts() {
        for (field in board){
            if (field is Mine){
                val fields: ArrayList<IField> = getAdjacentFields(field)

                for (f in fields){
                    f.bombValue++
                }
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
            val pos = Position((0 until fieldHeight).random(),(0 until fieldWidth).random())

            if (!tempList.contains(pos)){
                tempList.add(pos)
            }
        }
        return tempList
    }

    private fun evaluateMove(field: IField) {
        getAdjacentFieldsForEnabling(field)
        for (f in enablingFields){
            f.isEnabled = true
        }
        enablingFields = ArrayList()
    }

    private fun hasAdjacentMines(adjacentFields: ArrayList<IField>): Boolean {
        for (field in adjacentFields){
            if (field is Mine){
                return true
            }
        }
        return false
    }
    private fun getAdjacentFieldsForEnabling(field: IField){
        val fields = getAdjacentFields(field)
        if (!hasAdjacentMines(fields)){
            for (f in fields) {
                if (!enablingFields.contains(f)){
                    enablingFields.add(f)
                    if (f.bombValue == 0){
                        getAdjacentFieldsForEnabling(f)
                    }
                }
            }
        }
    }

    private fun getAdjacentFields(field: IField): ArrayList<IField> {
        val temp : ArrayList<IField> = ArrayList()
        board.find { item -> item.pos.X == field.pos.X -1 && item.pos.Y == field.pos.Y}
            ?.let { temp.add(it) }
        board.find { item -> item.pos.X == field.pos.X +1 && item.pos.Y == field.pos.Y}
            ?.let { temp.add(it) }
        board.find { item -> item.pos.X == field.pos.X && item.pos.Y == field.pos.Y - 1}
            ?.let { temp.add(it) }
        board.find { item -> item.pos.X == field.pos.X && item.pos.Y == field.pos.Y + 1}
            ?.let { temp.add(it) }
        board.find { item -> item.pos.X == field.pos.X -1 && item.pos.Y == field.pos.Y -1}
            ?.let { temp.add(it) }
        board.find { item -> item.pos.X == field.pos.X -1 && item.pos.Y == field.pos.Y + 1}
            ?.let { temp.add(it) }
        board.find { item -> item.pos.X == field.pos.X + 1 && item.pos.Y == field.pos.Y - 1}
            ?.let { temp.add(it) }
        board.find { item -> item.pos.X == field.pos.X + 1 && item.pos.Y == field.pos.Y + 1}
            ?.let { temp.add(it) }

        return temp
    }

    fun onLongClickBoard(field: IField) {
        if (!field.isEnabled){
            if (!field.isFlagged){
                field.setFlag()
                bombCount--
            }
            else {
                field.removeFlag()
                bombCount++
            }
        }

    }

    fun onClickBoard(field: IField) {
        if (!field.isFlagged){
            field.isEnabled = true
            if (field is Mine){
                showGameOver()
            }else{
                evaluateMove(field)
            }
        }
        if(bombCount == 0){
            showWin()
        }
    }

    private fun showWin() {
        //Implement win state
    }

    private fun showGameOver() {
        //Implement game over state
    }
}