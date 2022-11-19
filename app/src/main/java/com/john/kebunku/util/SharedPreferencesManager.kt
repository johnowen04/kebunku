package com.john.kebunku.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesManager {
    private const val sharedFile = "com.john.kebunku"

    private const val USERNAME = "username"

    private fun getPreferences(context: Context) : SharedPreferences =
        context.getSharedPreferences(sharedFile, Context.MODE_PRIVATE)

    private fun getEditor(context: Context) : SharedPreferences.Editor =
        getPreferences(context).edit()

    fun getUsername(context: Context) : String =
        getPreferences(context).getString(USERNAME, "") ?: ""

    fun setUsername(username: String, context: Context) {
        getEditor(context).putString(USERNAME, username).commit()
    }

    fun clearUsername(context: Context) {
        getEditor(context).remove(USERNAME).commit()
    }
}