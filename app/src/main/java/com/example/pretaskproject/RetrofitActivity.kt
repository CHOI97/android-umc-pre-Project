package com.example.pretaskproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pretaskproject.databinding.ActivityRetrofitBinding
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityRetrofitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRetrofitBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        var gson= GsonBuilder().setLenient().create()
        //웹브라우저창열기
        val retrofit = Retrofit.Builder()
            .baseUrl("${BuildConfig.URL_BOOKSTORE}")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        //주소를 입력했다
        val apiService = retrofit.create(ApiService::class.java)

        //입력한 주소 중 하나로 연결 시도
        apiService.getBookstoreInfo("applcation/json","${BuildConfig.API_KEY}","1", "1")
            .enqueue(object : Callback<Response> {
                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    Log.d("확인",response.raw().request().url().url().toString())
//                    Log.d("확인2", response.body().toString())
                    if (response.isSuccessful) {
                        val responseData = response.body()
                        if (responseData != null) {
                            Log.d("Retrofit", "${response.body()}")
                        } else {
                            Log.d("Retrofit", "responseData == null")
                        }
                    } else {
                        Log.w("Retrofit", "Response Not Successful ${response.code()}")
                    }
                }
                override fun onFailure(call: Call<Response>, t: Throwable) {
                    Log.e("Retrofit","Error!", t)
                }
            })

    }
}