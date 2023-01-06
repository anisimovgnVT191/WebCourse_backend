package com.anisimov.domain.usecase

import com.anisimov.data.MainRepository
import com.anisimov.data.entity.CatalogGoodsResponse
import com.anisimov.data.entity.CatalogItem

interface FetchCatalogGoodsByIdUseCase {
    suspend operator fun invoke(withId: String): CatalogGoodsResponse
}

class FetchCatalogGoodsByIdUseCaseImpl(private val repository: MainRepository): FetchCatalogGoodsByIdUseCase {
    override suspend operator fun invoke(withId: String): CatalogGoodsResponse {
        return repository.getGoodsItemsForId(withId)
    }
}
