package com.example.software_systems_business_logic_lab1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [CassandraAutoConfiguration::class, CassandraDataAutoConfiguration::class])
class SoftwareSystemsBusinessLogicLab1Application

fun main(args: Array<String>) {
    runApplication<SoftwareSystemsBusinessLogicLab1Application>(*args)
}