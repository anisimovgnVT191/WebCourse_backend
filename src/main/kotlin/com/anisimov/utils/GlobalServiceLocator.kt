package com.anisimov.utils

import com.anisimov.data.MainRepositoryImpl
import com.anisimov.data.datasource.LocalDataSourceImpl
import com.anisimov.data.datasource.database.connection.DatastoreConnection
import com.anisimov.domain.usecase.*

object GlobalServiceLocator {
    private val datastoreConnection = DatastoreConnection()
    private val localDataSource = LocalDataSourceImpl(datastoreConnection)
    private val repository = MainRepositoryImpl(localDataSource)

    val fetchBlogPostsUseCase: FetchBlogPostsUseCase
        get() = FetchBlogPostsUseCaseImpl(repository = repository)

    val fetchCatalogItemsUseCase: FetchCatalogItemsUseCase
        get() = FetchCatalogItemsUseCaseImpl(repository = repository)

    val fetchCatalogGoodsByIdUseCase: FetchCatalogGoodsByIdUseCase
        get() = FetchCatalogGoodsByIdUseCaseImpl(repository = repository)

    val fetchDetailedGoodById: FetchDetailedGoodById
        get() = FetchDetailedGoodByIdImpl(repository = repository)
}