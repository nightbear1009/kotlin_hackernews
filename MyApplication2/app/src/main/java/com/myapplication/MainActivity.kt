package com.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    val mItems: ArrayList<Item> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit = Retrofit.Builder()
                .baseUrl("https://hacker-news.firebaseio.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create<HackerNewsService>(HackerNewsService::class.java)


        service.topStories().enqueue(object : Callback<List<String>> {
            override fun onFailure(call: Call<List<String>>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<List<String>>?, response: Response<List<String>>?) {
                if (response != null) {

                    response.body()!!.forEach { s ->
                        service.details(s).enqueue(object : Callback<DetailModel> {
                            override fun onFailure(call: Call<DetailModel>?, t: Throwable?) {

                            }

                            override fun onResponse(call: Call<DetailModel>?, response: Response<DetailModel>?) {
                                val item = Item(s, response!!.body()!!.title)
                                mItems.add(item)

                                Log.d("Ted", item.s +" " + item.title)
                            }

                        })
                    }

                }
            }

        })
    }
}
