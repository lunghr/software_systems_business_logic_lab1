package com.example.software_systems_business_logic_lab1.application.controllers

import com.example.software_systems_business_logic_lab1.application.dto.ProductDto
import com.example.software_systems_business_logic_lab1.application.models.Product
import com.example.software_systems_business_logic_lab1.application.services.ProductService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/product")
@Tag(name = "Controller for creating, updating and deleting products")
class ProductController(
    private val productService: ProductService
) {

    @Operation(summary = "Create a new product")
    @PostMapping("/create")
    fun createProduct(
        @RequestBody productDto: ProductDto
    ): Product {
        return productService.createProduct(productDto)
    }

}