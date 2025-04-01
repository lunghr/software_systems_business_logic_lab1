package com.example.software_systems_business_logic_lab1.payment.bank


import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bank")
class PaymentController(
    private val paymentService: PaymentService
) {
    @PostMapping("/payment-ozon")
    fun processPayment(
        @Valid @RequestBody request: PaymentRequest
    ): ResponseEntity<String> {
        val result = paymentService.processPayment(
                request.cardNumber,
        request.cvv,
        request.expirationDate,
        request.totalPrice
        )
        return ResponseEntity.ok(result)
    }
}
