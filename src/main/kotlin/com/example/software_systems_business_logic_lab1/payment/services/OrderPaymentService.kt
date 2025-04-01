package com.example.software_systems_business_logic_lab1.payment.services

import com.example.software_systems_business_logic_lab1.payment.dto.OrderPaymentRequest
import com.example.software_systems_business_logic_lab1.payment.entities.PaymentDataForOzon
import com.example.software_systems_business_logic_lab1.payment.repos.PaymentCardRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.HttpEntity



@Service
class OrderPaymentService(
    private val restTemplate: RestTemplate,
    private val paymentCardRepository: PaymentCardRepository
) {
    fun processOrderPayment(cardNumber: String, totalPrice: Double): String {
        val paymentCard = paymentCardRepository.findByCardNumber(cardNumber)
            ?: return "Карта не найдена"

        // Создаем DTO для платежа
        val paymentRequest = OrderPaymentRequest(
            cardNumber = cardNumber,
            cvv = paymentCard.cvv,
            expirationDate = paymentCard.expirationDate,
            totalPrice = totalPrice
        )

        val url = "http://localhost:8080/bank/payment-ozon"

        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
        }
        val requestEntity = HttpEntity(paymentRequest, headers)

        return restTemplate.postForObject(url, requestEntity, String::class.java)
            ?: "Ошибка обработки платежа"
    }

    fun getAllCardNumbers(userId: Int): List<String> {
        return paymentCardRepository.findAllByUserId(userId).map { it.cardNumber }
    }

    fun addNewPaymentCard(paymentCard: PaymentDataForOzon): PaymentDataForOzon {
        return paymentCardRepository.save(paymentCard)
    }
}