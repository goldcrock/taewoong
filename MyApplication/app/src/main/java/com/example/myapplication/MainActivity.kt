package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import okhttp3.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataUrl()
    }
    private fun dataUrl() {
        //資料網址
        val dataUrl =
            "https://api.zippopotam.us/us/33162"

        //Part 1: 宣告 OkHttpClient
        val okHttpClient = OkHttpClient().newBuilder().build()

        //Part 2: 宣告 Request，要求要連到指定網址
        val request: Request = Request.Builder().url(dataUrl).get().build()

        //Part 3: 宣告 Call
        val call = okHttpClient.newCall(request)

        //執行 Call 連線後，採用 enqueue 非同步方式，獲取到回應的結果資料
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: java.io.IOException) {
                Log.d("HKT", "onFailure: $e")
            }

            override fun onResponse(call: Call, response: Response) {
                //Log.d("HKT", "onResponse: ${response.body?.string()}")
                val tv: TextView = findViewById(R.id.tv1)
                val datas = response.body?.string()
                runOnUiThread {
                    tv.text = datas
                }

            }
        })
    }
}