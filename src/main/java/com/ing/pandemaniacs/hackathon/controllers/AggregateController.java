package com.ing.pandemaniacs.hackathon.controllers;

import com.ing.pandemaniacs.hackathon.interfaces.AggregateOperations;
import com.ing.pandemaniacs.hackathon.model.Category;
import com.ing.pandemaniacs.hackathon.services.AggregationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/aggregate")
public class AggregateController implements AggregateOperations {
    private final AggregationService aggregationService;

    public AggregateController(final AggregationService aggregationService) {
        this.aggregationService = aggregationService;
    }

    @Override
    public Map<Category, Double> getMonthlyAmountsByCategoriesPerUser(String user, int month, int year) {
        return aggregationService.getMonthlyAmountsByCategoriesPerUser(user, month, year);
    }

    @Override
    public Map<Category, Double> getYearlyAmountsByCategoriesPerUser(String user, int year) {
        return aggregationService.getYearlyAmountsByCategoriesPerUser(user, year);
    }

}
