package com.mockcompany.webapp.service;

import com.mockcompany.webapp.data.ProductItemRepository;
import com.mockcompany.webapp.model.ProductItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SearchService {
    private final ProductItemRepository productItemRepository;

    public SearchService(ProductItemRepository productItemRepository) {
        this.productItemRepository = productItemRepository;
    }

    public Collection<ProductItem> search(String query) {
        List<ProductItem> itemList = new ArrayList<>();

        if (query.startsWith("\"") && query.endsWith("\"")) {
            query = query.replace("\"", "");
            this.productItemRepository
                    .findAllByNameIgnoreCaseOrDescriptionIgnoreCase(query, query)
                    .forEach(itemList::add);
        } else {
            this.productItemRepository
                    .findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query)
                    .forEach(itemList::add);
        }
        return itemList;
    }

    public Collection<ProductItem> findAll() {
        List<ProductItem> allProductItems = new ArrayList<>();
        this.productItemRepository.findAll().forEach(allProductItems::add);
        return allProductItems;
    }
}
