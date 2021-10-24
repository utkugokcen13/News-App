package com.utkugokcen.newsapp.repository

import com.utkugokcen.newsapp.api.RetrofitInstance
import com.utkugokcen.newsapp.database.ArticleDatabase

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)
}