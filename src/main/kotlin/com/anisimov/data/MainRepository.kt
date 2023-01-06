package com.anisimov.data

import com.anisimov.data.entity.*

interface MainRepository {
    suspend fun getCatalogItems(): List<CatalogItem>

    suspend fun getBlogPosts(): List<BlogPost>

    suspend fun getGoodsItemsForId(id: String): CatalogGoodsResponse

    suspend fun getDetailedGoodById(id: String): GoodDetailedItem
}