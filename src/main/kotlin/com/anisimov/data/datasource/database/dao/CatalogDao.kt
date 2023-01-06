package com.anisimov.data.datasource.database.dao

import com.anisimov.data.datasource.database.objects.CatalogTable
import com.anisimov.data.datasource.database.utils.StringEntityClass
import com.anisimov.data.entity.CatalogItem
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class CatalogDao(id: EntityID<String>): Entity<String>(id) {
    val customId by CatalogTable.id
    val title by CatalogTable.title
    val imageUrl by CatalogTable.imageUrl

    fun toApiResponse(): CatalogItem {
        return CatalogItem(id = this.customId.value, title = this.title, imageUrl = this.imageUrl)
    }

    companion object : StringEntityClass<CatalogDao>(CatalogTable)
}