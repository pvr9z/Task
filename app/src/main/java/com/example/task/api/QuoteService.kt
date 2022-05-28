package com.example.task.api

import com.example.task.models.QuoteList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")
    fun getQuotes(@Query("page") page: Int): Observable<QuoteList>

}