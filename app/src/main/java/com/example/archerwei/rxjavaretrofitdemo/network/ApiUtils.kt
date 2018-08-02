package com.example.archerwei.rxjavaretrofitdemo.network

import android.content.Context

class ApiUtils {

    //設定Api 連線主機
    companion object {

        private var DOMAIN_URL = ""

        fun setDev(context:Context){
            DOMAIN_URL = "https://rss.itunes.apple.com/api/v1/test"
        }

        fun setPrd(context:Context){
            DOMAIN_URL = "https://rss.itunes.apple.com/api/v1/"
        }

        fun getApiDomain() = DOMAIN_URL

        val CODE_SUCCESS:Int = 0

    }
}