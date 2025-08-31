package com.mb.juneandroidbatch.retrofit.network

import com.mb.juneandroidbatch.retrofit.dataclass.QuoteList
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApi {

    @GET("/quotes")
    suspend fun getQuotes(): Response<QuoteList>


}