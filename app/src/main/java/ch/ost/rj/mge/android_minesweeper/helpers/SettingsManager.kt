package ch.ost.rj.mge.android_minesweeper.helpers

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsManager(context: Context) {
    private val dataStore = context.createDataStore(name = "settings_pref")

    fun getIsDarkMode() : Flow<Boolean> {
        return dataStore.data.map {
            preference -> preference[IS_DARK_MODE] ?: false
        }
    }

    suspend fun setIsDarkMode(isDarkMode: Boolean) {
        dataStore.edit { preferences -> preferences[IS_DARK_MODE] = isDarkMode }
    }

    companion object {
        val IS_DARK_MODE = preferencesKey<Boolean>("dark_mode")
    }
}