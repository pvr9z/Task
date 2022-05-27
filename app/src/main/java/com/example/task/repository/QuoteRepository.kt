package com.example.task.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.task.api.QuoteService
import com.example.task.models.QuoteList
import com.example.task.utils.NetworkUtils

class QuoteRepository(
    private val quoteService: QuoteService,
    private val applicationContext: Context
) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
    get() = quotesLiveData

    suspend fun getQuotes(page: Int) {
        if(NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quoteService.getQuotes(page)
            if(result.body() != null) quotesLiveData.postValue(result.body())
        }
    }
}







