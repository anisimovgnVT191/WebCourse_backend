package com.anisimov.data.datasource.database.dao

import com.anisimov.data.datasource.database.objects.GoodsTable
import com.anisimov.data.datasource.database.utils.StringEntityClass
import com.anisimov.data.entity.GoodItem
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.id.EntityID

class GoodsDao(id: EntityID<String>): Entity<String>(id) {
    val customID by GoodsTable.id
    val imageUrl by GoodsTable.imageUrl
    val title by GoodsTable.title
    val catalogId by GoodsTable.catalogId
    val description by GoodsTable.description

    fun toApiResponse(): GoodItem {
        return GoodItem(
            id = customID.value,
            imageUrl = imageUrl,
            title =title,
            price = 0.0,
            description = description
        )
    }

    companion object : StringEntityClass<GoodsDao>(GoodsTable)
}