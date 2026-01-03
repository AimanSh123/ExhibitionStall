package com.example.exhibitionstall.model
import java.math.BigDecimal



data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val registeredAt: String,
    val cart: Cart?
)

data class Cart(
    val id: Int,
    val userId: Int,
    val createdAt: String,
    val updatedAt: String,
    val items: List<CartItem>
)

data class CartItem(
    val id: Int,
    val cartId: Int,
    val stallItem: StallItem,
    val quantity: Int,
    val addedAt: String
)


data class Stall(
    val id: Int,
    val name: String,
    val description: String,
    val location: String,
    val rating: BigDecimal?,
    val imageUrl: String?,
    val items: List<StallItem>
)

data class StallItem(
    val id: Int,
    val stallId: Int,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val available: Boolean,
    val imageUrl: String?
)


data class Order(
    val id: Int,
    val userId: Int,
    val stallId: Int,
    val deliveryPartner: DeliveryPartner?,
    val status: String,
    val totalAmount: BigDecimal,
    val placedAt: String,
    val updatedAt: String,
    val items: List<OrderItem>
)

data class OrderItem(
    val id: Int,
    val stallItem: StallItem,
    val quantity: Int,
    val price: BigDecimal
)


data class DeliveryPartner(
    val id: Int,
    val name: String,
    val phone: String,
    val email: String,
    val assignedSince: String
)

