package com.example.software_systems_business_logic_lab1.payment.bank


import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository : JpaRepository<PaymentDataForBank, Long> {
    fun findByCardNumber(cardNumber: String): PaymentDataForBank?
}
