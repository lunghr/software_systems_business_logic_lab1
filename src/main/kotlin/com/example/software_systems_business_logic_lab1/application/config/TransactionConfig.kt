import com.atomikos.icatch.jta.UserTransactionImp
import com.atomikos.icatch.jta.UserTransactionManager
import jakarta.transaction.TransactionManager
import jakarta.transaction.UserTransaction
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.jta.JtaTransactionManager

@Configuration
@EnableTransactionManagement
class TransactionConfig {

    @Bean
    fun userTransaction(): UserTransaction {
        return UserTransactionImp()
    }

    @Bean
    fun atomikosTransactionManager(): TransactionManager {
        val transactionManager = UserTransactionManager()
        transactionManager.init()
        return transactionManager
    }

    @Bean
    fun jtaTransactionManager(): JtaTransactionManager {
        return JtaTransactionManager(userTransaction(), atomikosTransactionManager())
    }
}