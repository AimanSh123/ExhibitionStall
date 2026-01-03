package com.example.exhibitionstall

import androidx.lifecycle.ViewModel
import com.example.exhibitionstall.model.CartItem
import com.example.exhibitionstall.model.Product
import com.example.exhibitionstall.model.Stall
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import com.example.exhibitionstall.data.dummyStalls

class ExhibitionViewModel : ViewModel() {

    private val _stalls = MutableStateFlow(dummyStalls)
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