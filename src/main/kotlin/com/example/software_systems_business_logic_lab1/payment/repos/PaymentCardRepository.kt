package com.example.software_systems_business_logic_lab1.payment.repos

import com.example.software_systems_business_logic_lab1.payment.entities.PaymentDataForOzon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentCardRepository : JpaRepository<PaymentDataForOzon, Long> {
    fun findByCardNumber(cardNumber: String): PaymentDataForOzon?
}