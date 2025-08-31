package com.mb.juneandroidbatch.retrofit.dataclass

data class QuoteList(
    val limit: Int,
    val quotes: List<Quote>,
    val skip: Int,
    val total: Int
)