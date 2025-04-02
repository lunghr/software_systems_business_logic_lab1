package com.example.software_systems_business_logic_lab1.application.services

import com.example.software_systems_business_logic_lab1.application.models.*
import com.example.software_systems_business_logic_lab1.application.models.key_classes.CartProductKey
import com.example.software_systems_business_logic_lab1.application.models.key_classes.CatalogSubcatalogKey
import com.example.software_systems_business_logic_lab1.application.models.key_classes.OrderProductKey
import jakarta.persistence.Id
import java.util.UUID

fun toSubcatalog(catalogName: String, subcatalogName: String): Subcatalog {
    return Subcatalog(
        key = CatalogSubcatalogKey(
            subcatalogName = subcatalogName,
            catalogName = catalogName
        )
    )
}


fun toCartProduct(cartId: UUID, productId: UUID, quantity: Int): CartProduct {
    return CartProduct(
        key = CartProductKey(
            cartId = cartId,
            productId = productId
        ),
        quantity = quantity
    )
}

fun getOnlyValidProducts(cartProducts: List<CartProduct>): List<CartProduct> {
    return cartProducts.filter { cartProduct ->
        cartProduct.quantity > 0
    }
}

fun getListOfUUIDs(cartProducts: List<CartProduct>): List<UUID> {
    return cartProducts.map { cartProduct ->
        cartProduct.key.productId
    }
}

fun toOrder(user: User): Order{
    return Order(
        user = user,
        totalPrice = 0.0,
    )
}

fun toOrderProduct(orderId:UUID, productId: UUID, quantity: Int): OrderProduct {
    return OrderProduct(
        key = OrderProductKey(
            orderId = orderId,
            productId = productId
        ),
        quantity = quantity
    )
}


