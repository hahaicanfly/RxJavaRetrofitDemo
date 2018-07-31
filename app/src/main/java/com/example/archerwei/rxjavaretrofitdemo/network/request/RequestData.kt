package com.example.archerwei.rxjavaretrofitdemo.network.request

data class RequestData(
        val country: String,
        val media: String,
        val type: String,
        val genre: String,
        val limit: Int,
        val format: String
)