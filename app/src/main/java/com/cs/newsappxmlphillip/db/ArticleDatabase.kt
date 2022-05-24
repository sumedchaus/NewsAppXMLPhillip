package com.cs.newsappxmlphillip.db

import android.content.Context
import androidx.room.*
import com.cs.newsappxmlphillip.model.Article

//database class for room always need to be abstract

@Database(
    entities = [Article::class],
    version = 2,
)

@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile  // other threads can see immediately when it changes and update
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()

        // when we initialize or instantiate our object then the invok fun also called
        // i.e when we called Article Database then the invoke is also called
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context
                    .applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }
}