package com.anisimov.domain.usecase

import com.anisimov.data.MainRepository
import com.anisimov.data.entity.GoodDetailedItem

interface FetchDetailedGoodById {
    suspend operator fun invoke(id: String): GoodDetailedItem
}

class FetchDetailedGoodByIdImpl(private val repository: MainRepository): FetchDetailedGoodById {
    override suspend fun invoke(id: String): GoodDetailedItem {
        return repository.getDetailedGoodById(id)
    }
}