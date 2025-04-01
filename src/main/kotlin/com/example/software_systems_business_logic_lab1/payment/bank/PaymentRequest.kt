package com.example.software_systems_business_logic_lab1.payment.bank

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class PaymentRequest(

    @field:NotBlank(message = "Номер карты обязателен")
    @field:Pattern(regexp = "\\d{16}", message = "Номер карты должен состоять из 16 цифр")
    val cardNumber: String,

    @field:NotBlank(message = "Срок действия обязателен")
    @field:Pattern(regexp = "(0[1-9]|1[0-2])/\\d{2}", message = "Дата должна иметь формат MM/YY")
    val expirationDate: String,

    @field:NotBlank(message = "CVV обязателен")
    @field:Pattern(regexp = "\\d{3}", message = "CVV должен состоять из 3 цифр")
    val cvv: String,
    
    val totalPrice: Double
)