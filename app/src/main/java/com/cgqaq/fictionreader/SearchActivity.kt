package com.cgqaq.fictionreader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.cgqaq.fictionreader.databinding.ActivitySearchBinding
import com.cgqaq.fictionreader.viewmodel.SearchViewModel
import kotlinx.coroutines.launch

class SearchActivity : AppCompatActivity() {
    val searchViewModel by lazy {
        ViewModelProvider(this).get(SearchViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchSearchbutton.setOnClickListener{
            val query = binding.searchEdittext.text
            if (query.isNotEmpty()){
                lifecycleScope.launch {
                    searchViewModel.search(query.toString())
                }
            }
        }
    }
}