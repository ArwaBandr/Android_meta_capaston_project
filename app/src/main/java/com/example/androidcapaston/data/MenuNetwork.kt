package com.example.androidcapaston.data

import androidx.room.PrimaryKey
import com.example.androidcapaston.data.database.MenuItemRoom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuNetwork(
    @SerialName("menu")
    val menuItems: List<MenuItemNetwork> = emptyList()
)

@Serializable
data class MenuItemNetwork(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String
){
    fun toMenuItemRoom() = MenuItemRoom(
        id = id,
        title = title,
        price = price.toDouble(),
        description = description,
        image = image,
        category = category
    )
}