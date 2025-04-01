package com.example.software_systems_business_logic_lab1.payment.bank
import jakarta.persistence.*

@Entity
@Table(name = "bank_cards_data")
data class PaymentDataForBank(
    //TODO add wallet join
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "card_number", nullable = false)
    val cardNumber: String,
    @Column(name = "cvv", nullable = false)
    val cvv: String,
    @Column(name = "expiration_date", nullable = false)
    val expirationDate: String,
    @Column(name = "balance", nullable = false)
    var balance: Double = 0.0
)