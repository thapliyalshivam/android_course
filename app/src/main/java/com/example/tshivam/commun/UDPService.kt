package com.example.tshivam.commun

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class UDPService : Service() {
    override fun onBind(intent: Intent?): IBinder {
        return null!!
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
          Log.e("asdasdasdas","sas")
        return Service.START_NOT_STICKY;
    }

    override fun onCreate() {
        Log.e("created","sas")
      //  super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}