package com.cgqaq.fictionreader.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cgqaq.fictionreader.URL_CHS
import com.cgqaq.fictionreader.api.Search
import com.cgqaq.fictionreader.model.SearchModel
import org.jsoup.Jsoup
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val TAG = "SearchViewModel"

class SearchViewModel: ViewModel() {
    val search = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create()).baseUrl(URL_CHS).build().create(Search::class.java)

    suspend fun search(query: String): SearchModel{
        val string = search.search(query).await()
        val dom = Jsoup.parse(string)

        Log.w(TAG, dom.charset().displayName())

        return SearchModel()
    }

}