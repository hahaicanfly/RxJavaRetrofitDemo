package com.example.archerwei.rxjavaretrofitdemo.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseApiHelper {

    var retrofit: Retrofit?
    constructor() {
        retrofit = Retrofit.Builder()
                .baseUrl(ApiUtils.getApiDomain())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .build()
//        apiService = createRetrofitApiService(ApiService::class.java)
    }

    open fun<T> createRetrofitApiService(service: Class<T>):T{
        val apiService = retrofit!!.create(service)
        return apiService
    }

}