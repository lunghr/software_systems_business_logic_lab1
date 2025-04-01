package com.example.software_systems_business_logic_lab1.payment.bank

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/payment")
class PaymentController(
    private val paymentService: PaymentService
) {
    @PostMapping("/process")
    fun processPayment(
        @RequestParam cardNumber: String,
        @RequestParam cvv: String,
        @RequestParam expirationDate: String,
        @RequestParam amount: Double
    ): ResponseEntity<String> {
        val result = paymentService.processPayment(cardNumber, cvv, expirationDate, amount)
        return ResponseEntity.ok(result)
    }
}
