package com.example.bank.service

//import com.example.bank.dto.Product
import com.example.bank.repository.PaymentCardRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class OrderPaymentService(
    private val restTemplate: RestTemplate,
    private val paymentCardRepository: PaymentCardRepository
) {
    fun processOrderPayment(cardNumber: String, products: List<Double>): String {
        // Находим данные карты в БД по номеру
        val paymentCard = paymentCardRepository.findByCardNumber(cardNumber)
            ?: return "Карта не найдена"

        // Расчитываем итоговую сумму заказа
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