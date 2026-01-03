package com.example.exhibitionstall.data

import com.example.exhibitionstall.model.Category
import com.example.exhibitionstall.model.Product
import com.example.exhibitionstall.model.Stall

val dummyStalls = listOf(

    Stall(
        id = 1,
        name = "Tech Innovators",
        description = "Showcasing the latest in AI and robotics.",
        imageUrl = "placeholder_tech",
        category = Category.TECHNOLOGY,
        products = listOf(
            Product(
                id = "T1",
                name = "AI Robot Kit",
                price = 12999.0,
                category = "Technology",
                imageUrl = "product_robot"
            ),
            Product(
                id = "T2",
                name = "Smart Glasses",
                price = 7999.0,
                category = "Technology",
                imageUrl = "product_glasses"
            )
        )
    ),

    Stall(
        id = 2,
        name = "Gourmet Bites",
        description = "Delicious culinary creations from local chefs.",
        imageUrl = "placeholder_food",
        category = Category.FOOD,
        products = listOf(
            Product(
                id = "F1",
                name = "Cheese Burst Pizza",
                price = 299.0,
                category = "Food",
                imageUrl = "product_pizza"
            ),
            Product(
                id = "F2",
                name = "Chocolate Brownie",
                price = 149.0,
                category = "Food",
                imageUrl = "product_brownie"
            )
        )
    ),

    Stall(
        id = 3,
        name = "Fashion Forward",
        description = "Trendy apparel and accessories for all seasons.",
        imageUrl = "placeholder_clothing",
        category = Category.CLOTHING,
        products = listOf(
            Product(
                id = "C1",
                name = "Denim Jacket",
                price = 1999.0,
                category = "Clothing",
                imageUrl = "product_jacket"
            ),
            Product(
                id = "C2",
                name = "Leather Belt",
                price = 799.0,
                category = "Clothing",
                imageUrl = "product_belt"
            )
        )
    ),

    Stall(
        id = 4,
        name = "Future Gadgets",
        description = "Interactive demos of upcoming tech products.",
        imageUrl = "placeholder_tech",
        category = Category.TECHNOLOGY,
        products = listOf(
            Product(
                id = "T3",
                name = "VR Headset",
                price = 14999.0,
                category = "Technology",
                imageUrl = "product_vr"
            ),
            Product(
                id = "T4",
                name = "Drone Camera",
                price = 9999.0,
                category = "Technology",
                imageUrl = "product_drone"
            )
        )
    ),

    Stall(
        id = 5,
        name = "Sweet Treats",
        description = "Artisan desserts and baked goods.",
        imageUrl = "placeholder_food",
        category = Category.FOOD,
        products = listOf(
            Product(
                id = "F3",
                name = "Cupcakes (Pack of 6)",
                price = 249.0,
                category = "Food",
                imageUrl = "product_cupcake"
            ),
            Product(
                id = "F4",
                name = "Macarons",
                price = 349.0,
                category = "Food",
                imageUrl = "product_macaron"
            )
        )
    ),

    Stall(
        id = 6,
        name = "Eco-Wear",
        description = "Sustainable and organic clothing options.",
        imageUrl = "placeholder_clothing",
        category = Category.CLOTHING,
        products = listOf(
            Product(
                id = "C3",
                name = "Organic Cotton T-Shirt",
                price = 999.0,
                category = "Clothing",
                imageUrl = "product_tshirt"
            ),
            Product(
                id = "C4",
                name = "Reusable Tote Bag",
                price = 499.0,
                category = "Clothing",
                imageUrl = "product_tote"
            )
        )
    ),

    Stall(
        id = 7,
        name = "Robo-Adventures",
        description = "Explore the world of advanced robotics.",
        imageUrl = "placeholder_tech",
        category = Category.TECHNOLOGY,
        products = listOf(
            Product(
                id = "T5",
                name = "Programmable Robot",
                price = 18999.0,
                category = "Technology",
                imageUrl = "product_robot_pro"
            )
        )
    ),

    Stall(
        id = 8,
        name = "Spice Route",
        description = "Exotic spices and international cuisine.",
        imageUrl = "placeholder_food",
        category = Category.FOOD,
        products = listOf(
            Product(
                id = "F5",
                name = "Garam Masala Set",
                price = 399.0,
                category = "Food",
                imageUrl = "product_spices"
            ),
            Product(
                id = "F6",
                name = "Thai Curry Paste",
                price = 299.0,
                category = "Food",
                imageUrl = "product_curry"
            )
        )
    )
)
