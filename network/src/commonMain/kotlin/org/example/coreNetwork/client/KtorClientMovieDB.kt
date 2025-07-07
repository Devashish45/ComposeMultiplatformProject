package org.example.coreNetwork.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClientMovieDB {

    //https://api.themoviedb.org/3/trending/movie/day?language=en-US
    private const val HOST_MOVIE_DB = "api.themoviedb.org"
    fun getInstance(): HttpClient = HttpClient {

        install(ContentNegotiation) {
            json(json = Json {
                ignoreUnknownKeys = true
            })
        }
        install(DefaultRequest) {
            url {
                host = HOST_MOVIE_DB
                protocol = URLProtocol.HTTPS
                parameters.append("api_key", "f8f3ab3d34d55edc30478ef0a17243e4")
                parameters.append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmOGYzYWIzZDM0ZDU1ZWRjMzA0NzhlZjBhMTcyNDNlNCIsIm5iZiI6MTQ5MDM3MDE3My4xNzgsInN1YiI6IjU4ZDUzZTc5OTI1MTQxMWY4MTAyZGQ2NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.nEzu8dbtpIQdPlibVWbOVGJddUYsBHAXc1Cynm8DtKQ")
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }

        install(HttpTimeout) {
            socketTimeoutMillis = 3000
            connectTimeoutMillis = 3000
            requestTimeoutMillis = 3000
        }

//TO-DO enable logging for debug build
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }

    }
}