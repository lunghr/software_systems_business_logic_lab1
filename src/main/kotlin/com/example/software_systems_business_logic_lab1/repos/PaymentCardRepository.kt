package com.example.bank.repository

import com.example.bank.model.PaymentCard
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentCardRepository : JpaRepository<PaymentCard, Long> {
    fun findByCardNumber(cardNumber: String): PaymentCard?
}