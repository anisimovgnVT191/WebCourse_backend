package com.anisimov.routes

import com.anisimov.data.entity.CatalogGoodsResponse
import com.anisimov.data.entity.CatalogItem
import com.anisimov.domain.usecase.FetchCatalogGoodsByIdUseCase
import com.anisimov.domain.usecase.FetchCatalogItemsUseCase
import io.github.smiley4.ktorswaggerui.dsl.get
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.catalogRouting(
    fetchCatalogItemsUseCase: FetchCatalogItemsUseCase,
    fetchCatalogGoodsByIdUseCase: FetchCatalogGoodsByIdUseCase
) {
    route(path = "/catalog") {
        get({
            description = "Получить массив со всеми айтемами каталога"
            response {
                HttpStatusCode.OK to {
                    description = "Вовзвращает массив айтемов каталога"
                    body(Array<CatalogItem>::class)
                }
            }
        }) {
            call.respond(fetchCatalogItemsUseCase())
        }

        get("/{id}", {
            description = "Получить все книги из каталога"
            request {
                pathParameter<String>("id") {
                    description = "Айди айтема каталога"
                }
            }
            response {
                HttpStatusCode.OK to {
                    description = "Возвращает название каталога и массив книг из этого каталога"
                    body(CatalogGoodsResponse::class)
                }
            }
        }){
            call.parameters["id"]?.let {id ->
                call.respond(fetchCatalogGoodsByIdUseCase(withId = id))
            }
        }
    }
}