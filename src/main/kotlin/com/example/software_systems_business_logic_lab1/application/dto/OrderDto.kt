package com.example.software_systems_business_logic_lab1.application.dto
import com.example.software_systems_business_logic_lab1.application.models.Order
import com.example.software_systems_business_logic_lab1.application.models.enums.OrderStatus
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Schema(description = "Order Data Transfer Object for creating a new order or updating an existing one")
data class OrderDto(
        @Schema(description = "Total amount", example = "999.99")
        val totalPrice: Double,

) {
    fun toOrder(): Order {
        return Order(
            createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm dd.MM.yy")),
            totalPrice = totalPrice,
            id = TODO(),
            user = TODO(),
            orderStatus = OrderStatus.WAITING_FOR_PAYMENT,
        )
    }
}