package com.example.openweatherapi.service.client

import com.google.gson.Gson
import org.springframework.stereotype.Component
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

// https://openweathermap.org/current
@Component
class ApiHttpClient {

    private val baseUrl = "http://api.openweathermap.org/data/2.5/weather"

    private fun getClient(): HttpClient {
        return HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build()
    }

    private fun getRequest(url: String): HttpRequest? {
        return HttpRequest.newBuilder()
            .uri(URI(url))
            .version(HttpClient.Version.HTTP_2)
            .GET()
            .build()
    }

    fun getByQueryParam(queryParam: String): Any? {

        val url = "$baseUrl?$queryParam&appid=${System.getenv("OPEN_WEATHER_API")}"
        val response: HttpResponse<String> = getClient().send(getRequest(url), HttpResponse.BodyHandlers.ofString())

        return Gson().fromJson(response.body(), Any::class.java)
    }
}