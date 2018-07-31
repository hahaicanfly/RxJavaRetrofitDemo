package com.example.archerwei.rxjavaretrofitdemo.network

import com.example.archerwei.rxjavaretrofitdemo.model.ResponseItem
import com.example.archerwei.rxjavaretrofitdemo.network.response.ResultResponse
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Api Request interface
 * **/
interface ApiService {

    /**
     * GET
     * **/
    @GET("{country}/{media}/{type}/{genre}/{limit}/{format}")
    fun getResult(
            @Path("country") country: String,
            @Path("media") media: String,
            @Path("type") type: String,
            @Path("genre") genre: String,
            @Path("limit") limit: Int,
            @Path("format") format: String): Observable<ResultResponse>


    /**
     * POST
     * **/
    @POST("")
    fun postRequest(
            @Header("header") token: String,
            @QueryMap params: Map<String,String>,
            @Body bodyJson: String
    ): Observable<ResponseItem<String>>
}