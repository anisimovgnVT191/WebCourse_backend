package com.anisimov.routes

import com.anisimov.domain.usecase.FetchCatalogGoodsByIdUseCase
import com.anisimov.domain.usecase.FetchCatalogItemsUseCase
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.catalogRouting(
    fetchCatalogItemsUseCase: FetchCatalogItemsUseCase,
    fetchCatalogGoodsByIdUseCase: FetchCatalogGoodsByIdUseCase
) {
    route(path = "/catalog") {
        get {
            call.respond(fetchCatalogItemsUseCase())
        }

        get("/{id}"){
            call.parameters["id"]?.let {id ->
                call.respond(fetchCatalogGoodsByIdUseCase(withId = id))
            }
        }
    }
}