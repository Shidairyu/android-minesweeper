package ch.ost.rj.mge.android_minesweeper.model

interface IField {
    var fieldImage: Int
    var isEnabled: Boolean
    var pos: Position
    var bombValue: Int
}