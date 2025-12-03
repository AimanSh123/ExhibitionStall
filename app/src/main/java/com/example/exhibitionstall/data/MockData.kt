package com.example.exhibitionstall.data

import com.example.exhibitionstall.model.DeliveryPartner
import com.example.exhibitionstall.model.Order
import com.example.exhibitionstall.model.Product

object MockData {
    val allProducts = listOf(
        Product("1", "Margherita Pizza", 12.99, "Pizza"),
        Product("2", "Pepperoni Pizza", 14.99, "Pizza"),
        Product("3", "Veggie Burger", 8.99, "Burger"),
        Product("4", "Cheese Burger", 9.99, "Burger"),
        Product("5", "Coke", 1.99, "Drink"),
        Product("6", "Garlic Bread", 4.99, "Side"),
        Product("7", "BBQ Chicken Pizza", 16.99, "Pizza")
    )

    // Simulating user's current cart
    val currentCart = listOf(
        allProducts[0], // Margherita
        allProducts[5]  // Garlic Bread
    )

    // Simulating past/active orders
    val myOrders = listOf(
        Order(
            id = "ORD-9921",
            items = listOf(allProducts[1]),
            status = "Out for Delivery",
            estimatedArrival = "2:15 PM",
            partner = DeliveryPartner("John Doe", "5551234567")
        ),
        Order(
            id = "ORD-8810",
            items = listOf(allProducts[3], allProducts[4]),
            status = "Delivered",
            estimatedArrival = "Yesterday",
            partner = DeliveryPartner("Alice Smith", "5559876543")
        )
    )

    fun getOrderById(id: String): Order? = myOrders.find { it.id == id }

    // Feature 2 Logic: Similar Products
    fun getSimilarProducts(cart: List<Product>): List<Product> {
        val cartCategories = cart.map { it.category }.toSet()
        val cartIds = cart.map { it.id }.toSet()

        return allProducts.filter { product ->
            product.category in cartCategories && product.id !in cartIds
        }
    }
}