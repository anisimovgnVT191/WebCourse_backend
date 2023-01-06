package com.anisimov.data.datasource.database.objects

import com.anisimov.data.datasource.database.utils.StringIdTable
import org.jetbrains.exposed.sql.javatime.date

object BlogsTable: StringIdTable(name = "\"WebApp\".\"Blogs\"", columnName = "id", columnLength = 256) {
    val title = varchar("title", 256)
    val description = varchar("description", 256)
    val publishDate = varchar("publishDate", 256)
    val author = varchar("author", 256)
}