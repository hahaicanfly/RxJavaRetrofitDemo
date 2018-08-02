package com.example.archerwei.rxjavaretrofitdemo.network

import com.example.archerwei.rxjavaretrofitdemo.network.request.RequestData
import com.example.archerwei.rxjavaretrofitdemo.network.response.ResultResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 初始化Retrofit 元件
 * **/

class ApiHelper : BaseApiHelper {
    companion object {
        const val TAG = "ApiHelper"
    }
    var apiService: ApiService?

    constructor() {
        apiService = createRetrofitApiService(ApiService::class.java)
    }

    //帶入參數
    fun getResult(rq: RequestData): Observable<ResultResponse> {
        return apiService!!.getResult(rq.country, rq.media, rq.type, rq.genre, rq.limit, rq.format)
    }

}