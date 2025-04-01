package com.example.bank.controller

import com.example.bank.dto.OrderPaymentRequest
import com.example.bank.service.OrderPaymentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order/payment")
class OrderPaymentController(
    private val orderPaymentService: OrderPaymentService
) {
    @PostMapping("/process")
    fun processOrderPayment(@RequestBody request: OrderPaymentRequest): ResponseEntity<String> {
        val result = orderPaymentService.processOrderPayment(request.cardNumber, request.products)
        return ResponseEntity.ok(result)
    }
}