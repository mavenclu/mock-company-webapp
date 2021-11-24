package com.mockcompany.webapp.controller;

import com.mockcompany.webapp.api.SearchReportResponse;
import com.mockcompany.webapp.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Management decided it is super important that we have lots of products that match the following terms.
 * So much so, that they would like a daily report of the number of products for each term along with the total
 * product count.
 */
@RestController
public class ReportController {

    private static final String[] importantTerms = new String[]{
            "Cool",
            "Amazing",
            "Perfect",
            "Kids"
    };

    private final SearchService searchService;

    @Autowired
    public ReportController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping("/api/products/report")
    public SearchReportResponse runReport() {
        Map<String, Integer> hits = new HashMap<>();
        for (String term : importantTerms) {
            hits.put(term, searchService.search(term).size());
        }
        SearchReportResponse response = new SearchReportResponse();
        response.setSearchTermHits(hits);
        response.setProductCount(searchService.findAll().size());
        return response;
    }

}
