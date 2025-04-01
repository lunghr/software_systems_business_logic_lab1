package com.example.bank.dto

data class OrderPaymentRequest(
    val cardNumber: String,
    val products: List<Double>
)