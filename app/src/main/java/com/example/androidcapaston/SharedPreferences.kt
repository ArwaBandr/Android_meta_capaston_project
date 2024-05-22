package com.example.androidcapaston
import android.content.Context
import android.content.SharedPreferences

object PreferencesHelper {
     const val PREFS_NAME = "user_prefs"
     const val KEY_USERFNAME = "fname"
     const val KEY_EMAIL = "email"
     const val KEY_USERLNAME = "lname"

     fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveUserData(context: Context, username: String, lastusername: String,email: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString(KEY_USERFNAME, username)
        editor.putString(KEY_USERLNAME, lastusername)
        editor.putString(KEY_EMAIL, email)
        editor.apply()
    }
    fun getFirstname(context: Context): String? {
        return getSharedPreferences(context).getString(KEY_USERFNAME, null)
    }
    fun getLastname(context: Context): String? {
        return getSharedPreferences(context).getString(KEY_USERLNAME, null)
    }
    fun getEmail(context: Context): String? {
        return getSharedPreferences(context).getString(KEY_EMAIL, null)
    }
    fun clearUserData(context: Context) {
        val editor = getSharedPreferences(context).edit()
        editor.clear()
        editor.apply()
    }
}