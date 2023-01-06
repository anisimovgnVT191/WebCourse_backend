package com.anisimov.data.datasource.database.objects

import com.anisimov.data.datasource.database.utils.StringIdTable

object GoodsTable: StringIdTable(name = "\"WebApp\".\"Goods\"", columnName = "id", columnLength = 256) {
    val title = varchar("title", 256)
    val description = varchar("description", 256)
    val imageUrl = varchar("imageUrl", 256)
    val catalogId = varchar("catalogId", 256)
}