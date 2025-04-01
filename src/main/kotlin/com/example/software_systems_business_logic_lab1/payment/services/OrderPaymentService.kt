package com.example.software_systems_business_logic_lab1.payment.services

//import com.example.bank.dto.Product
import com.example.software_systems_business_logic_lab1.payment.repos.PaymentCardRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class OrderPaymentService(
    private val paymentCardRepository: PaymentCardRepository
) {

    private val restTemplate: RestTemplate = RestTemplate()

    fun processOrderPayment(cardNumber: String, products: List<Double>): String {
        // Находим данные карты в БД по номеру
        val paymentCard = paymentCardRepository.findByCardNumber(cardNumber)
            ?: return "Карта не найдена"

        val totalAmount = products.sumOf { it }

        // Формирование URL для вызова PaymentController
        val url = "http://localhost:8080/payment/process" +
                "?cardNumber=$cardNumber" +
                "&cvv=${paymentCard.cvv}" +
                "&expirationDate=${paymentCard.expirationDate}" +
                "&amount=$totalAmount"

        // Отправка POST-запроса к контроллеру банка
        return restTemplate.postForObject(url, null, String::class.java)
            ?: "Ошибка обработки платежа"
    }
}