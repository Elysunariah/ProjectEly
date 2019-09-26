package com.ely.projectely.prefshelper

import android.content.Context
import android.content.SharedPreferences

class PrefsHelper {
    val USER_LOGIN = "login"

    var mContext : Context
    var sharedSet : SharedPreferences

    constructor(ctx : Context) {
        mContext = ctx
        sharedSet = mContext.getSharedPreferences("APLIKASITESTDB",
            Context.MODE_PRIVATE)
    }

    fun SaveLogin(status: Boolean){
        val edit = sharedSet.edit()
        edit.putBoolean(USER_LOGIN, status)
        edit.apply()
    }
    fun getStatusLogin(): Boolean?{
        return sharedSet.getBoolean(USER_LOGIN, false)
    }



}