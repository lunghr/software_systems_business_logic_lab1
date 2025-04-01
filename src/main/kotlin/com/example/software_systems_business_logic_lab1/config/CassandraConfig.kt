package com.example.software_systems_business_logic_lab1.config

import com.datastax.oss.driver.api.core.CqlSession
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.core.CassandraTemplate
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories

@Configuration
@EnableCassandraRepositories
class CassandraConfig {
    @Bean
    fun cassandraTemplate(session: CqlSession): CassandraTemplate {
        return CassandraTemplate(session)
    }

    @Bean
    fun getSession(): CqlSession {
        return CqlSession.builder().withKeyspace("lab1").build()
    }
}
