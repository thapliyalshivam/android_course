package com.example.tshivam.commun.pojo

import android.app.Application
import android.content.Context


class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        Retro.setUpRetrofitClient(applicationContext)

    }


}
