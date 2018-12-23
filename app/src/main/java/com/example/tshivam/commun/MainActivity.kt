package com.example.tshivam.commun
import com.example.tshivam.commun.pojo.Retro
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.widget.Toast
import com.example.tshivam.commun.pojo.ApiResponse

import retrofit2.Call
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

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
        startForegroundService(inn)

        val Inpu = Inpu()


        val Displ = Displ()


        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.editBox,Inpu).addToBackStack(null)
        transaction.add(R.id.displayBox,Displ).addToBackStack(null).commit()

      //
        // val udpConnect = Thread(ClientSendAndListen()).start()

        Retro.get().apiGetUsers("shivam").enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>?, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    Log.d("apiiiiii",response.body()?.items.toString())
                //    view?.successDeleteApi()
                }
            }

            override fun onFailure(call: Call<ApiResponse>?, t: Throwable?) {

                Log.d("tatitttttt",t?.message)

//                view?.dismissLoading()
//                view?.failureApi()
            }
        })


    }
}
