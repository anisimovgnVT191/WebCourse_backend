package com.anisimov.data.datasource

import com.anisimov.data.entity.BlogPost
import com.anisimov.data.entity.CatalogGoodsResponse
import com.anisimov.data.entity.CatalogItem
import com.anisimov.data.entity.GoodDetailedItem

interface LocalDataSource {
    suspend fun getCatalogItems(): List<CatalogItem>

    suspend fun getBlogPosts(): List<BlogPost>

    suspend fun getGoodsItemsForId(id: String): CatalogGoodsResponse

    suspend fun getDetailedGoodById(id: String): GoodDetailedItem
}