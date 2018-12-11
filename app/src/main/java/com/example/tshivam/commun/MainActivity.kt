package com.example.tshivam.commun

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , Update{
    override fun callback(text: String) {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()

        val displayUnit = supportFragmentManager.findFragmentById(
                R.id.displayBox) as Displ
        displayUnit.update(text)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inn =  Intent(this,UDPService::class.java)
        startService(inn)

        val Inpu = Inpu()


        val Displ = Displ()


        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.editBox,Inpu).addToBackStack(null)
        transaction.add(R.id.displayBox,Displ).addToBackStack(null).commit()

      //
        // val udpConnect = Thread(ClientSendAndListen()).start()





    }
}
