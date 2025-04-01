package com.example.software_systems_business_logic_lab1.application.controllers

import com.example.software_systems_business_logic_lab1.application.services.CatalogService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/catalog")
@Tag(name = "Controller for sorting and searching in catalog")
class CatalogController(
    private val catalogService: CatalogService,
) {
    //TODO return exceptions

    @Operation(summary = "Create a new catalog")
    @PostMapping("/create/{catalogName}")
    fun createCatalog(
        @Parameter(
            description = "Catalog name",
            example = "clothes"
        )
        @PathVariable catalogName: String
    ) {
        catalogService.createCatalog(catalogName)
    }

    @Operation(summary = "Create a new subcatalog")
    @PostMapping("/create/{catalogName}/{subcatalogName}")
    fun createSubcatalog(
        @Parameter(
            description = "Catalog name",
            example = "clothes"
        )
        @PathVariable catalogName: String,
        @Parameter(
            description = "Subcatalog name",
            example = "electronics"
        )
        @PathVariable subcatalogName: String
    ) {
        catalogService.createSubcatalog(catalogName, subcatalogName)
    }

    @Operation(summary = "Get all catalogs")
    @GetMapping("/get/catalogs")
    fun getCatalogs(): List<String> {
        return catalogService.getCatalogs().map { it.name }
    }

    @Operation(summary = "Get all subcatalogs of a catalog")
    @GetMapping("/get/catalogs/{catalogName}/subcatalogs")
    fun getSubcatalogs(
        @Parameter(
            description = "Catalog name",
            example = "clothes"
        )
        @PathVariable catalogName: String
    ): List<String> {
        return catalogService.getSubcatalogsByCatalog(catalogName).map { it.key.subcatalogName }
    }

    @Operation(summary = "Get all products of a subcatalog")
    @GetMapping("/get/catalogs/{catalogName}/subcatalogs/{subcatalogName}/products")
    fun getProducts(
        @Parameter(
            description = "Catalog name",
            example = "clothes"
        )
        @PathVariable catalogName: String,
        @Parameter(
            description = "Subcatalog name",
            example = "electronics"
        )
        @PathVariable subcatalogName: String
    ): List<String> {
        return catalogService.getProductsBySubcatalog(subcatalogName).map { it.name }
    }

}