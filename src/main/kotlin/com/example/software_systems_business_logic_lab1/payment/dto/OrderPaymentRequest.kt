package com.example.software_systems_business_logic_lab1.payment.dto

data class OrderPaymentRequest(
    val cardNumber: String,
    val products: List<Double>
)