package com.example.archerwei.rxjavaretrofitdemo.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.archerwei.rxjavaretrofitdemo.R
import com.example.archerwei.rxjavaretrofitdemo.network.ApiHelper
import com.example.archerwei.rxjavaretrofitdemo.network.ApiUtils
import com.example.archerwei.rxjavaretrofitdemo.network.request.RequestData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.AsyncSubject
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("===  doamin ====  ", ApiUtils.getApiDomain())

        button.setOnClickListener{ loadRequest() }
    }

    fun loadRequest() {
        val apiHelper = ApiHelper()
        val reqData = RequestData(
                country = "us",
                media = "apple-music",
                type = "hot-tracks",
                genre = "all",
                limit = 100,
                format = "explicit.json"
        )

        val asyncSubject: AsyncSubject<Any> = AsyncSubject.create()
        //send api request
        asyncSubject.onSubscribe(apiHelper.getResult(reqData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->

                    when (result.statusCode) {
                        ApiUtils.CODE_SUCCESS -> {
                            Log.d(TAG, "==== size ====: " + result.feed!!.results!!.size)
//                            for (resp in result.feed!!.results!!){
//                                Log.d(TAG, "==== name ====: "+resp.artistName)
//                            }
                        }
                        else -> {
                        }
                    }

                }, { e ->
                    e.printStackTrace()
                }))
    }
}
