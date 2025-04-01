import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Card(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val cardNumber: String,
    val cvv: String,
    val expirationDate: String,
    var balance: Double
) {
    constructor() : this(0, "", "", "", 0.0)
}