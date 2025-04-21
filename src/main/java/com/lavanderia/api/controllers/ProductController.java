package com.lavanderia.api.controllers;

import com.lavanderia.api.dto.DetailsRequest;
import com.lavanderia.api.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/details")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<DetailsRequest>> findDetailsProduct(@RequestParam(defaultValue = "0") int page,
                                                                   @RequestParam(defaultValue = "3") int items) {
        List<DetailsRequest> details = this.productService.findDetailsProduct(page, items);
        return ResponseEntity.ok(details);
    }

}
