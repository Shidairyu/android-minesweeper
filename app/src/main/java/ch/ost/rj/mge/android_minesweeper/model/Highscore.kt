package ch.ost.rj.mge.android_minesweeper.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ch.ost.rj.mge.android_minesweeper.helpers.Difficulty
import java.time.LocalDateTime

@Entity(tableName = "highscores")
class Highscore(@ColumnInfo val username : String,
                @ColumnInfo val difficulty: Difficulty,
                @ColumnInfo val durationInSeconds: String) : Comparable<Highscore> {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0

    override fun toString(): String {
        return "$username, $difficulty game, $durationInSeconds seconds"
    }

    override fun compareTo(other: Highscore): Int {
        if(difficulty == other.difficulty){
            return durationInSeconds.compareTo(other.durationInSeconds);
        }
        return difficulty.compareTo(other.difficulty)
    }
}