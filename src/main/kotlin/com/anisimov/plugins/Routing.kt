package com.anisimov.plugins

import com.anisimov.data.MainRepositoryImpl
import com.anisimov.routes.blogRouting
import com.anisimov.routes.catalogRouting
import com.anisimov.routes.goodsRoute
import com.anisimov.utils.GlobalServiceLocator
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*


fun Application.configureRouting() {
    routing {
        catalogRouting(
            fetchCatalogItemsUseCase = GlobalServiceLocator.fetchCatalogItemsUseCase,
            fetchCatalogGoodsByIdUseCase = GlobalServiceLocator.fetchCatalogGoodsByIdUseCase
        )
        blogRouting(useCase = GlobalServiceLocator.fetchBlogPostsUseCase)
        goodsRoute(fetchDetailedGoodById = GlobalServiceLocator.fetchDetailedGoodById)
    }
}
