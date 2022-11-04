package ch.ost.rj.mge.android_minesweeper.model

import ch.ost.rj.mge.android_minesweeper.R

interface IField {
    var fieldImage: Int
    var isEnabled: Boolean
    var pos: Position
    var bombValue: Int
    var isFlagged: Boolean
    fun updateFieldImage()
    fun setFlag(){
        if(!isFlagged){
            fieldImage = R.drawable.flag
            isFlagged = true
        }
    }
    fun removeFlag() {
        if (isFlagged){
            fieldImage = 0
            isFlagged = false
        }
    }
}