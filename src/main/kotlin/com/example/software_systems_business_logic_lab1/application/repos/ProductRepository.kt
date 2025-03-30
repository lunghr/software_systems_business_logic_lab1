package com.example.software_systems_business_logic_lab1.application.repos

import com.example.software_systems_business_logic_lab1.application.models.Product
import com.example.software_systems_business_logic_lab1.application.models.key_classes.ProductSubcatalogKey
import org.springframework.data.cassandra.repository.CassandraRepository

interface ProductRepository: CassandraRepository<Product, ProductSubcatalogKey> {
}