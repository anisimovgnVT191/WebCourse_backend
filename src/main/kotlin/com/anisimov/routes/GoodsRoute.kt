package com.anisimov.routes

import com.anisimov.domain.usecase.FetchDetailedGoodById
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.goodsRoute(fetchDetailedGoodById: FetchDetailedGoodById) {
    route(path = "/good") {
        get(path = "/{id}") {
            call.parameters["id"]?.let {
                call.respond(fetchDetailedGoodById(it))
            }
        }
    }
}