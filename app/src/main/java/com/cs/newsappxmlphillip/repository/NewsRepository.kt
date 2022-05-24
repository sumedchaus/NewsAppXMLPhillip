package com.cs.newsappxmlphillip.repository

import com.cs.newsappxmlphillip.db.ArticleDatabase
import com.cs.newsappxmlphillip.network.RetrofitInstance

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

        suspend fun searchNews(searchQuery : String,pageNumber: Int){
            RetrofitInstance.api.searchForNews(searchQuery,pageNumber)
        }
}