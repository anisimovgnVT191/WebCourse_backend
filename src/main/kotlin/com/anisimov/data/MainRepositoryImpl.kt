package com.anisimov.data

import com.anisimov.data.datasource.LocalDataSource
import com.anisimov.data.entity.*
import java.util.*

class MainRepositoryImpl(
    private val localDataSource: LocalDataSource
): MainRepository {
    override suspend fun getCatalogItems(): List<CatalogItem> {
        return localDataSource.getCatalogItems()
    }

    override suspend fun getBlogPosts(): List<BlogPost> {
        return localDataSource.getBlogPosts()
    }

    override suspend fun getGoodsItemsForId(id: String): CatalogGoodsResponse {
        return localDataSource.getGoodsItemsForId(id)
    }

    override suspend fun getDetailedGoodById(id: String): GoodDetailedItem {
        return localDataSource.getDetailedGoodById(id)
    }
}