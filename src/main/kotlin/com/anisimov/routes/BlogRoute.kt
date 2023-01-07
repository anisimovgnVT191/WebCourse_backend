package com.anisimov.routes

import com.anisimov.data.entity.BlogPost
import com.anisimov.domain.usecase.FetchBlogPostsUseCase
import io.github.smiley4.ktorswaggerui.dsl.get
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.blogRouting(useCase: FetchBlogPostsUseCase) {
    route(path = "/blogs") {
        get({
            description = "Получить все блоги"
            response {
                HttpStatusCode.OK to {
                    description = "Возвращает массив постов"
                    body(Array<BlogPost>::class)
                }
            }
        }) {
            call.respond(useCase())
        }
    }
}