package com.example.pretaskproject
import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "d9cc505aa61591d224d3a5c0f92abfe0")
    }
}