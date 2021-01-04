package com.example.openweatherapi.controller

import com.example.openweatherapi.service.client.ApiHttpClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest

@RestController
@RequestMapping("/api")
class ApiController(private val httpClient: ApiHttpClient) {

    @GetMapping("")
    @ResponseBody
    fun byQueryParam(webRequest: WebRequest): Any? {
        var q = ""

        val count = 0
        for ((k, v) in webRequest.parameterMap) {
            q += if (count == 0) {
                k + "=" + v[0]
            } else {
                "&" + k + "=" + v[0]
            }

        }

        return ApiHttpClient().getByQueryParam(queryParam = q)
    }
}