package ch.ost.rj.mge.android_minesweeper.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ch.ost.rj.mge.android_minesweeper.helpers.Difficulty
import java.time.LocalDateTime

@Entity(tableName = "highscores")
class Highscore(@ColumnInfo val username : String,
                @ColumnInfo val dateTime: LocalDateTime,
                @ColumnInfo val difficulty: Difficulty,
                @ColumnInfo val durationInSeconds: Int) : Comparable<Highscore> {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0;

    override fun toString(): String {
        val formattedDateTime = dateTime.toLocalDate();
        return "$formattedDateTime: $username, $difficulty game, $durationInSeconds seconds"
    }

    override fun compareTo(other: Highscore): Int {
        return durationInSeconds.compareTo(other.durationInSeconds);
    }
}