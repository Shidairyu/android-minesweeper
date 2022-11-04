package ch.ost.rj.mge.android_minesweeper.model.database

import androidx.room.TypeConverter
import ch.ost.rj.mge.android_minesweeper.helpers.Difficulty
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDateTime? {
        return value?.let { LocalDateTime.ofInstant(Instant.ofEpochMilli(value), ZoneOffset.UTC) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): Long? {
        return date?.atZone(ZoneOffset.UTC)?.toInstant()?.toEpochMilli()
    }

    @TypeConverter
    fun difficultyToInt(difficulty: Difficulty): Int {
        return Difficulty.convertToInt(difficulty)
    }

    @TypeConverter
    fun intToDifficulty(value: Int): Difficulty {
        return Difficulty.convertFromInt(value)
    }
}