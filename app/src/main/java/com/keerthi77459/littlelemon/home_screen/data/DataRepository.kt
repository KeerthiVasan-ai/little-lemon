package com.keerthi77459.littlelemon.home_screen.data

import com.keerthi77459.littlelemon.home_screen.services.MenuNetworkData
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class DataRepository(private val httpClient: HttpClient) {
    private val API_ENDPOINT =
        "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"

    suspend fun fetchMenuItems(): MenuNetworkData {
        val response: String = httpClient.get(API_ENDPOINT) {
            headers {
                append(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                append(HttpHeaders.Accept, ContentType.Application.Json.toString())
            }
        }.body()

        val menuData: MenuNetworkData = Json.decodeFromString(response)
        println(menuData.items)
        return menuData
    }
}
