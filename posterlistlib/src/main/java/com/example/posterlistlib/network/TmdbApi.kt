package com.example.posterlistlib.network

import com.example.posterlistlib.model.AllTrending
import com.example.posterlistlib.model.AllTrendingsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbApi{
    //BASE https://api.themoviedb.org/3/
    //Key api_key=fef98cf6bd829f53836bb7d92b02d6ef
    @GET("trending/all/day")
    fun getAllTrending() : Deferred<AllTrendingsResponse>

//    @GET("movie/{id}")
//    fun getMovieById(@Path("id") id:Int): Deferred<Response<TmdbMovie>>

}