package com.cs.newsappxmlphillip.db

import androidx.room.TypeConverter
import com.cs.newsappxmlphillip.model.Source

// room can get only premetive data types, i.e. string, int , bool, etc so we have to convert the source class in to string


class Converters {

    // to convert into string
    @TypeConverter
    fun fromSource(source: Source): String? {
        return source.name
    }

    @TypeConverter
    fun toSource(name:String): Source {
        return Source(name,name)
    }
}