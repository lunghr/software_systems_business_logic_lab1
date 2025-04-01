//package com.example.software_systems_business_logic_lab1.config
//
//import com.datastax.oss.driver.api.core.CqlSession
//import jakarta.annotation.PostConstruct
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.cassandra.core.CassandraTemplate
//import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories
//import java.net.InetSocketAddress
//
//@Configuration
//@EnableCassandraRepositories(basePackages = ["com.example.software_systems_business_logic_lab1.application.repos"])
//class CassandraConfig {
//
//    @Bean
//    fun getSession(): CqlSession {
//        return CqlSession.builder()
////            .addContactPoint(InetSocketAddress("cassandra", 9042))
//            .addContactPoint(InetSocketAddress("127.0.0.1", 9042))
//            .withKeyspace("lab1")
//            .withLocalDatacenter("datacenter1")
//            .build()
//    }
//
//    @Bean
//    fun cassandraTemplate(session: CqlSession): CassandraTemplate {
//        return CassandraTemplate(session)
//    }
//}
