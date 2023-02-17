package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.api.ApiInterface
import com.example.myapplication.api.RetrofitClient
import com.google.gson.Gson
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var txtData: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtData = findViewById(R.id.txtData)
        getCarContentList()
    }

    private fun getCarContentList() {
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                // Query String for Api Request
                val QUERY_STR = "IwAR2D4bp6kcEFBSrW4zITH0sX5VcN1p8xu8zscVI75CiN8SVOpqdftTsKU0s"
                val response = apiInterface.getAllContent(fbclid = QUERY_STR)
                if (response.isSuccessful) {
                    val json = Gson().toJson(response.body())
                    if (response.body()?.content?.size!! <= 0) {
                        Toast.makeText(
                            this@MainActivity,
                            "No car content found",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        txtData.text = json
                    }

                } else {
                    Toast.makeText(
                        this@MainActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex:Exception){
                Ex.localizedMessage?.let { Log.e("Error", it) }
            }
        }

    }

}