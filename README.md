Key points:

- It dynamically loads all JSON fields using `Gson().fromJson(response.body(), Any::class.java)`
- Api routes are not fixed to any specific query param, it's generic, so could be used for multiple cases

Example functional requests, ( reference: https://openweathermap.org/current )

- By zip code - http://localhost:8080/api?zip=94040
- By city name - http://localhost:8080/api?q=London
- By city ID - http://localhost:8080/api?id=2172797

More cases could be added per need


