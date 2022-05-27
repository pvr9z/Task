package com.example.task.work_manager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.task.QuoteApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteWorker(private val context: Context, params: WorkerParameters) :
    Worker(context, params) {

    override fun doWork(): Result {
        val pageNumber = (Math.random() * 10).toInt()
        val repository = (context as QuoteApplication).quoteRepository
        CoroutineScope(Dispatchers.IO).launch {
            repository.getQuotes(pageNumber)
        }
        return Result.success()
    }
}