package com.anisimov

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.anisimov.plugins.*
import io.github.smiley4.ktorswaggerui.SwaggerUI
import io.ktor.http.*
import io.ktor.server.plugins.defaultheaders.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(SwaggerUI)
    install(DefaultHeaders) {
        header(HttpHeaders.AccessControlAllowOrigin, value = "*")
    }
    configureSerialization()
    configureRouting()
}
