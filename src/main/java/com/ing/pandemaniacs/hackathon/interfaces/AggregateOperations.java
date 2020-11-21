package com.ing.pandemaniacs.hackathon.interfaces;

import com.ing.pandemaniacs.hackathon.model.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface AggregateOperations {

    // Monthly report per user with amounts summed by category
    @GetMapping(value = "/monthly", params = {"user", "month", "year"})
    Map<Category, Double> getMonthlyAmountsByCategoriesPerUser(@RequestParam("user") final String user,
                                                               @RequestParam("month") final int month,
                                                               @RequestParam("year") final int year);

    // Yearly report per user with amounts summed by category
    @GetMapping(value = "/yearly", params = {"user", "year"})
    Map<Category, Double> getYearlyAmountsByCategoriesPerUser(@RequestParam("user") final String user,
                                                              @RequestParam("year") final int year);

}