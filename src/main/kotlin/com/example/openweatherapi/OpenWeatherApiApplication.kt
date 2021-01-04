package com.example.openweatherapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OpenWeatherApiApplication

fun main(args: Array<String>) {
    runApplication<OpenWeatherApiApplication>(*args)
}
