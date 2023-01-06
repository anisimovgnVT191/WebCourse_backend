package com.anisimov.data.datasource

import com.anisimov.data.datasource.database.connection.DatastoreConnection
import com.anisimov.data.datasource.database.dao.BlogsDao
import com.anisimov.data.datasource.database.dao.CatalogDao
import com.anisimov.data.datasource.database.dao.GoodsDao
import com.anisimov.data.datasource.database.objects.CatalogTable
import com.anisimov.data.datasource.database.objects.GoodsTable
import com.anisimov.data.entity.*

class LocalDataSourceImpl(private val dbc: DatastoreConnection): LocalDataSource {
    override suspend fun getCatalogItems(): List<CatalogItem> {
        return dbc.query { CatalogDao.all().map { it.toApiResponse() } }
    }

    override suspend fun getBlogPosts(): List<BlogPost> {
        return dbc.query { BlogsDao.all().map { it.toApiResponse() } }
    }

    override suspend fun getGoodsItemsForId(id: String): CatalogGoodsResponse {
        val catalogTitle = dbc.query { CatalogDao[id] }.title
        val goods = dbc.query { GoodsDao.find { GoodsTable.catalogId eq id }.map { it.toApiResponse() } }

        return CatalogGoodsResponse(title = catalogTitle, goods = goods)
    }

    override suspend fun getDetailedGoodById(id: String): GoodDetailedItem {
        val good = dbc.query { GoodsDao.find { GoodsTable.id eq id }.first() }
        val catalogItem = dbc.query { CatalogDao.find { CatalogTable.id eq good.catalogId }.first() }.toShortItem()

        return GoodDetailedItem(catalogItem = catalogItem, good = good.toApiResponse())
    }
}

private fun CatalogDao.toShortItem(): CatalogShortItem {
    return CatalogShortItem(id = this.id.value, title = this.title)
}