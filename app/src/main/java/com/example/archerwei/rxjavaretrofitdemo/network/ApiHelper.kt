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

class ApiHelper{
    companion object {
        const val TAG = "ApiHelper"
    }

    var retrofit: Retrofit?
    var apiService: ApiService?

    constructor() {
        retrofit = Retrofit.Builder()
                .baseUrl(ApiUtils.getApiDomain())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()
        apiService = createRetrofitApiService(ApiService::class.java)
    }

    open fun<T> createRetrofitApiService(service: Class<T>):T{
        val apiService = retrofit!!.create(service)
        return apiService
    }


    //
    fun getResult(rq: RequestData): Observable<ResultResponse>{
        return apiService!!.getResult(rq.country,rq.media,rq.type,rq.genre,rq.limit,rq.format)
    }

}