package com.anisimov.data.datasource.database.objects

import com.anisimov.data.datasource.database.utils.StringIdTable

object CatalogTable: StringIdTable(name = "\"WebApp\".\"Catalog\"", columnName = "id", columnLength = 256){
    val title = varchar("title", 256)
    val imageUrl = varchar("imageUrl", 256)
}