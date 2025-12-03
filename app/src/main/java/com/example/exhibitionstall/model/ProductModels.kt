package com.example.exhibitionstall.model

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val category: String,
    val imageUrl: String = ""
)


data class DeliveryPartner(
    val name: String,
    val phoneNumber: String
)

data class Order(
    val id: String,
    val items: List<Product>,
    val status: String, // "Preparing", "Out for Delivery"
    val estimatedArrival: String, // "12:30 PM"
    val partner: DeliveryPartner
)

data class Stall(
    val id: Int,
    val name: String,
    val category: String,
    val products: List<Product>
)


data class CartItem(
    val product: Product,
    var quantity: Int
)