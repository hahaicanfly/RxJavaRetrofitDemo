package com.example.archerwei.rxjavaretrofitdemo.model

data class ResponseItem<T> (
        val code: Int,
        val msg: String,
        val error: String,
        val data: T
)


