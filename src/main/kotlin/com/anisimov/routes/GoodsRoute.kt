package com.anisimov.routes

import com.anisimov.data.entity.GoodDetailedItem
import com.anisimov.domain.usecase.FetchDetailedGoodById
import io.github.smiley4.ktorswaggerui.dsl.get
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.goodsRoute(fetchDetailedGoodById: FetchDetailedGoodById) {
    route(path = "/good") {
        get(path = "/{id}", {
            description = "Получить детальную информацию о книге"
            request {
                pathParameter<String>("id") {
                    description = "Айди книги"
                }
            }
            response {
                HttpStatusCode.OK to {
                    description = "Возвращает название категории каталога и детальную модель книги"
                    body(GoodDetailedItem::class)
                }
            }
        }) {
            call.parameters["id"]?.let {
                call.respond(fetchDetailedGoodById(it))
            }
        }
    }
}