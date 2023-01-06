package com.anisimov.routes

import com.anisimov.domain.usecase.FetchBlogPostsUseCase
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.blogRouting(useCase: FetchBlogPostsUseCase) {
    route(path = "/blogs") {
        get {
            call.respond(useCase())
        }
    }
}