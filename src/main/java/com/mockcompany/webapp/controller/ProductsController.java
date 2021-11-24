package com.mockcompany.webapp.controller;

import com.mockcompany.webapp.model.ProductItem;
import com.mockcompany.webapp.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    private final SearchService searchService;

    public ProductsController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping("/api/products/list")
    public Iterable<ProductItem> getAllProducts() {
        return searchService.findAll();
    }
}
