package com.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface HackerNewsService {
    @GET("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty")
    fun topStories(): Call<List<String>>

    @GET("https://hacker-news.firebaseio.com/v0/item/{id}.json?print=pretty")
    fun details(@Path("id") id: String): Call<DetailModel>
}



