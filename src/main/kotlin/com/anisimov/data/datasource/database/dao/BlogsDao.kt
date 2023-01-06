package com.anisimov.data.datasource.database.dao

import com.anisimov.data.datasource.database.objects.BlogsTable
import com.anisimov.data.datasource.database.utils.StringEntityClass
import com.anisimov.data.entity.BlogPost
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.time.format.DateTimeFormatter

class BlogsDao(id: EntityID<String>): Entity<String>(id) {
    val customId by BlogsTable.id
    val title by BlogsTable.title
    val description by BlogsTable.description
    val publishDate by BlogsTable.publishDate
    val author by BlogsTable.author

    fun toApiResponse(): BlogPost {
        return BlogPost(
            id = customId.value,
            title = title,
            description = description,
            publishDate = publishDate,
            author = author

        )
    }

    companion object : StringEntityClass<BlogsDao>(BlogsTable)
}