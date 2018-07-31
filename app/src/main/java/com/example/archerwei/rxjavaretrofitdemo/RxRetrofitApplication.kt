package com.example.archerwei.rxjavaretrofitdemo

import android.app.Application
import com.example.archerwei.rxjavaretrofitdemo.network.ApiUtils

class RxRetrofitApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        ApiUtils.setPrd(this)
        
    }
}