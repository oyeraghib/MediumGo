package com.example.mediumclone.ui.feed

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mediumclone.data.ArticlesRepo
import io.realworld.api.models.entities.Article
import io.realworld.api.models.responses.ArticlesResponse
import kotlinx.coroutines.launch

class FeedViewModel: ViewModel() {


    private val _feed = MutableLiveData<List<Article>>()

    val feed: LiveData<List<Article>> = _feed

    fun fetchGlobalFeed() = viewModelScope.launch {
        ArticlesRepo.getGlobalFeed().body()?.let {
            _feed.postValue(it.articles)
            Log.d("FEED", "feed fetched ${it.articles}")
        }

    }

}

