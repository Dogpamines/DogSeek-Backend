package com.dogpamines.dogseek.products.controller;

import com.dogpamines.dogseek.products.model.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductsController {

    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products/comparison")
    public ResponseEntity<Map<String, Object>> comparisonProducts(@RequestParam int prodCode1, int prodCode2) {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(new MediaType("application", "JSON", Charset.forName("UTF-8")));

        Map<String, Object> result = new HashMap<>();
        result.put("products", productsService.productsComparison(prodCode1,prodCode2));

        return new ResponseEntity<>(result, headers, HttpStatus.OK);
    }
}
