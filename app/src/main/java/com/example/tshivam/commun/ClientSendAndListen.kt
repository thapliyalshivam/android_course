package com.example.tshivam.commun


import android.util.Log

import java.io.IOException
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ClientSendAndListen : Runnable {

    var run = true


    public fun stopThread(){
        run = false

    }




    override fun run() {
        val serverAddr: InetAddress = InetAddress.getByName("192.168.0.113")


        try {
            val udpSocket = DatagramSocket(6789)
            try {
               // serverAddr = InetAddress.getByName("192.168.0.113")
            } catch (e: UnknownHostException) {
                Log.e("UnknownHostException", "UDP Connection:", e)
            }

            val buf = "FILES".toByteArray()
            val packet = DatagramPacket(buf, buf.size, serverAddr, 6789)


            try {
                udpSocket.send(packet)
            } catch (e: IOException) {
                Log.e("sending failed", "UDP Connection:", e)
            }


            while (run) {
                try {

                    val buf = ("FILES"+Math.random()*10000).toByteArray()
                    val packet = DatagramPacket(buf, buf.size, serverAddr, 6789)


                    try {
                        udpSocket.send(packet)
                    } catch (e: IOException) {
                        Log.e("sending failed", "UDP Connection:", e)
                    }



                    val message = ByteArray(8000)
                   // val packet = DatagramPacket(message, message.size)
                   // Log.i("UDP client: ", "about to wait to receive")
                  //  udpSocket.soTimeout = 10000
                   // udpSocket.receive(packet)
                   // val text = String(message, 0, packet.getLength())
                   // Log.d("Received text", text)
                }
                catch (e: IOException) {
                    Log.e(" UDP client has IOException", "error: ", e)
                    run = false
                    udpSocket.close()
                } catch (e: SocketTimeoutException) {
                    Log.e("Timeout Exception", "UDP Connection:", e)
                    run = false
                    udpSocket.close()
                }
                catch(e: InterruptedException ){

                     //   Thread.currentThread().interrupt();
                    }

            }




        } catch (e: SocketException) {
            Log.e("Socket Open:", "Error:", e)
        }

    }

}
