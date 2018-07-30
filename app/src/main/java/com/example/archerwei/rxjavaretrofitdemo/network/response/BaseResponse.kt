package com.example.archerwei.rxjavaretrofitdemo.network.response

abstract class BaseResponse {
    var statusCode: Int = 0
    var errMessage: String = "Message"
}