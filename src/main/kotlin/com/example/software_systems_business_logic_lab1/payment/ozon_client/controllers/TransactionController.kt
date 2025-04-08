package com.example.software_systems_business_logic_lab1.payment.ozon_client.controllers

import com.example.software_systems_business_logic_lab1.payment.ozon_client.services.TransactionService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("/transaction")
class TransactionController(
    private val transactionService: TransactionService
) {
    @PostMapping("/process/{orderId}/{paymentMethodId}")
    fun processTransaction(
        @PathVariable orderId: UUID,
        @PathVariable paymentMethodId: UUID
    ) = transactionService.processTransaction(
        paymentMethodId = paymentMethodId,
        orderId = orderId
    )
}