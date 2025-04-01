package com.example.software_systems_business_logic_lab1.payment.bank

import org.springframework.stereotype.Service

@Service
class PaymentService(
    private val cardRepository: CardRepository
) {
    fun processPayment(cardNumber: String, cvv: String, expirationDate: String, amount: Double): String {
        val card = cardRepository.findByCardNumber(cardNumber)

        if (card == null) {
            return "Карты с таким номером не существует."
        }

        if (card.cvv != cvv) {
            return "Неверный CVV."
        }

        if (card.expirationDate != expirationDate) {
            return "Срок действия карты истек."
        }

        if (card.balance < amount) {
            return "Недостаточно средств на карте."
        }

        card.balance -= amount
        cardRepository.save(card)

        return "Платеж успешно проведен. Сумма: $amount."
    }
}
