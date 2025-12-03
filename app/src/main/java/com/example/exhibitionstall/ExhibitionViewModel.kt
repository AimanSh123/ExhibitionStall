package com.example.exhibitionstall

import androidx.lifecycle.ViewModel
import com.example.exhibitionstall.model.CartItem
import com.example.exhibitionstall.model.Product
import com.example.exhibitionstall.model.Stall
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ExhibitionViewModel : ViewModel() {

    private val _stalls = MutableStateFlow(sampleStalls())
    val stalls: StateFlow<List<Stall>> = _stalls

    private val _cart = MutableStateFlow<List<CartItem>>(emptyList())
    val cart: StateFlow<List<CartItem>> = _cart

    fun addToCart(product: Product) {
        _cart.update { currentCart ->
            val existing = currentCart.find { it.product.id == product.id }
            if (existing != null) {
                currentCart.map {
                    if (it.product.id == product.id) it.copy(quantity = it.quantity + 1)
                    else it
                }
            } else {
                currentCart + CartItem(product, 1)
            }
        }
    }

    fun getStallById(stallId: Int): Stall? {
        return _stalls.value.find { it.id == stallId }
    }
}

fun sampleStalls(): List<Stall> {
    return listOf(
        Stall(
            id = 1,
            name = "Tech Stall",
            category = "Technology",
            products = listOf(
                Product(
                    id = "1",
                    name = "Smartwatch",
                    price = 2999.0,
                    category = "Gadgets",
                    imageUrl = ""
                ),
                Product(
                    id = "2",
                    name = "Earbuds",
                    price = 1599.0,
                    category = "Gadgets",
                    imageUrl = ""
                )
            )
        ),
        Stall(
            id = 2,
            name = "Food Corner",
            category = "Food",
            products = listOf(
                Product(
                    id = "3",
                    name = "Burger",
                    price = 99.0,
                    category = "Food",
                    imageUrl = ""
                ),
                Product(
                    id = "4",
                    name = "Fries",
                    price = 79.0,
                    category = "Food",
                    imageUrl = ""
                )
            )
        )
    )
}
