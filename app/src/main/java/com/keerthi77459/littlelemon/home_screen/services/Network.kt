package com.keerthi77459.littlelemon.home_screen.services

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetworkData(
    @SerialName("menu") val items: List<MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "title") val title: String,
    @SerialName(value = "description") val description: String,
    @SerialName(value = "price") val price: String,
    @SerialName(value = "image") val image: String,
    @SerialName(value = "category") val category: String,
)
