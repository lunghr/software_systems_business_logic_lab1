package com.example.software_systems_business_logic_lab1.payment.controllers

import com.example.software_systems_business_logic_lab1.payment.dto.OrderPaymentRequest
import com.example.software_systems_business_logic_lab1.payment.entities.PaymentDataForOzon
import com.example.software_systems_business_logic_lab1.payment.services.OrderPaymentService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/order/payment")
class OrderPaymentController(
    private val orderPaymentService: OrderPaymentService
) {
    @PostMapping("/process")
    fun processOrderPayment(@Valid @RequestBody request: OrderPaymentRequest): ResponseEntity<String> {
        val result = orderPaymentService.processOrderPayment(request.cardNumber, request.totalPrice)
        return ResponseEntity.ok(result)
    }

     @GetMapping("/all_cards")
    fun getAllCards(@RequestParam userId: Int): ResponseEntity<List<String>> {
        val cardNumbers = orderPaymentService.getAllCardNumbers(userId)
        return ResponseEntity.ok(cardNumbers)
    }

    @PostMapping("/add_card")
    fun addCard(@Valid @RequestBody request: PaymentDataForOzon): ResponseEntity<PaymentDataForOzon> {
        val newCard = PaymentDataForOzon(
            cardNumber = request.cardNumber,
            expirationDate = request.expirationDate,
            cvv = request.cvv,
            userId = request.userId
        )
        val savedCard = orderPaymentService.addNewPaymentCard(newCard)
        return ResponseEntity.ok(savedCard)
    }
}