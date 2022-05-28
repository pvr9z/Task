package com.example.task

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.task.adapter.QuoteAdapter
import com.example.task.viewmodels.MainViewModel
import com.example.task.viewmodels.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = (application as QuoteApplication).quoteRepository
        val adapter = QuoteAdapter()

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this) {
            it?.let {
                Log.d("Observing", "Running..")
                adapter.submitList(it.results)
            }
        }
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            this.adapter = adapter
            val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            addItemDecoration(itemDecorator)
        }
    }
}