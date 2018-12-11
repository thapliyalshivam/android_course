package com.example.tshivam.commun

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
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



//        Thread(Runnable {
//            // a potentially time consuming task
//            while (true){
//            Log.e("asdasdasdas",(Math.random()*10000).toString())}
//        }).start()




        return Service.START_NOT_STICKY;
    }


    private fun createNotificationChannel(channelId: String, channelName: String): String{
        val chan = NotificationChannel(channelId,
                channelName, NotificationManager.IMPORTANCE_NONE)
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(chan)
        return channelId
    }


    override fun onCreate() {
        Log.e("on create","create")

        val pendingIntent: PendingIntent =
                Intent(this, MainActivity::class.java).let { notificationIntent ->
                    PendingIntent.getActivity(this, 0, notificationIntent, 0)
                }
        val channelId =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    createNotificationChannel("my_service", "My Background Service")
                } else {
                    // If earlier version channel ID is not used
                    // https://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html#NotificationCompat.Builder(android.content.Context)
                    ""
                }

        val notification: Notification = Notification.Builder(this, channelId)
                .setContentTitle("Service")
                .setContentText("service initated")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setTicker("none")
                .build()

        startForeground(121, notification)
      //  super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}