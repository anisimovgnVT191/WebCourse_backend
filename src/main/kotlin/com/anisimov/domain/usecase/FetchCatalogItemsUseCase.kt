package com.anisimov.domain.usecase

import com.anisimov.data.MainRepository
import com.anisimov.data.entity.CatalogItem

interface FetchCatalogItemsUseCase {
    suspend operator fun invoke(): List<CatalogItem>
}

class FetchCatalogItemsUseCaseImpl(private val repository: MainRepository): FetchCatalogItemsUseCase {
    override suspend operator fun invoke(): List<CatalogItem> {
        return  repository.getCatalogItems()
    }
}