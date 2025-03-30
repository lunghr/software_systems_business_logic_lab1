package com.example.software_systems_business_logic_lab1.application.models.key_classes

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import java.util.UUID

@PrimaryKeyClass
data class CatalogSubcatalogKey(
    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED, name = "product_id")
    val catalogId: UUID,
    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED, name = "subcatalog_id")
    val subcatalogId: UUID = UUID.randomUUID()
)