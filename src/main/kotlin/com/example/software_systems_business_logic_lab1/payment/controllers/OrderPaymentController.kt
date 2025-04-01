package com.example.software_systems_business_logic_lab1.payment.controllers

import com.example.software_systems_business_logic_lab1.payment.dto.OrderPaymentRequest
import com.example.software_systems_business_logic_lab1.payment.services.OrderPaymentService
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