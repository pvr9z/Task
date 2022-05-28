package com.example.task

import android.app.Application
import com.example.task.api.QuoteService
import com.example.task.api.RetrofitHelper
import com.example.task.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        quoteRepository = QuoteRepository(quoteService, applicationContext)
    }
}