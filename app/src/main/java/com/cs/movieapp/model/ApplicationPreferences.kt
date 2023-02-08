package com.cs.fts.model

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class ApplicationPreferences @Inject constructor(

    @ApplicationContext
    private val context: Context
) {
    private val prefs: SharedPreferences = context.getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE)

    fun getUserName(): String?{

      return  prefs.getString(KEY_USER,"")

    }

    fun setUserName(userName:String){

        prefs.edit().putString(KEY_USER,userName).commit()

    }

    companion object{
        const val KEY_PREFS= "STORE_NAME"
        const val KEY_USER= "USERNAME"
    }
}