package com.example.task.models

data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<QuoteResult>,
    val totalCount: Int,
    val totalPages: Int
)