package com.cs.newsappxmlphillip.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cs.newsappxmlphillip.model.Article


@Dao
interface ArticleDao {
    //    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun upsert(article: Article): Long
//
//    @Query("SELECT * FROM articles")
//    fun getAllArticles(): LiveData<List<Article>>
//
//    @Delete
//    suspend fun deleteArticle(article: Article)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticle(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticles(article: Article)
}