package com.example.software_systems_business_logic_lab1.payment.entities

import jakarta.persistence.*

@Entity
@Table(name = "ozon_cards_data")
data class PaymentDataForOzon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "card_number", nullable = false)
    val cardNumber: String,
    @Column(name = "cvv", nullable = false)
    val cvv: String,
    @Column(name = "expiration_date", nullable = false)
    val expirationDate: String
)