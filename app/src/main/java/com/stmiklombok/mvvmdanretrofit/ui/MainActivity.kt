package com.stmiklombok.mvvmdanretrofit.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.stmiklombok.mvvmdanretrofit.databinding.ActivityMainBinding
import com.stmiklombok.mvvmdanretrofit.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel : MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        viewModel.getBooks()
        viewModel.book.observe(this){ data ->
            if (data != null){
                val adapter = BookAdapter(data)
                binding.recyclerView.adapter = adapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}