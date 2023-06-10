package com.capstone_bangkit.fitnessist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone_bangkit.fitnessist.api.ApiConfig
import com.capstone_bangkit.fitnessist.model.Article
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchArticleViewModel: ViewModel() {
    /*
    val listArticle = MutableLiveData<ArrayList<Article>>()

    fun setSearchArticle(query: String) {
        ApiConfig.getApiService().getSearchArticle(query).enqueue(object: Callback<ArticleResponse> {
            override fun onResponse(
                call: Call<ArticleResponse>,
                response: Response<ArticleResponse>
            ) {
                if (response.isSuccessful) {
                    listArticle.postValue(response.body()?.articles)
                }
            }

            override fun onFailure(call: Call<ArticleResponse>, t: Throwable) {
                Log.d("Failure", t.message.toString())
            }

        })
    }

    fun getSearchArticle(): LiveData<ArrayList<Article>> {
        return listArticle
    }
     */
}