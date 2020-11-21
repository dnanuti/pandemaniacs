package com.ing.pandemaniacs.hackathon.services;

import com.ing.pandemaniacs.hackathon.model.Category;
import com.ing.pandemaniacs.hackathon.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.ing.pandemaniacs.hackathon.TransactionsVisualizerApplication.TRANSACTION_CACHE;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

@Service
public class AggregationService {
    public Map<Category, Double> getMonthlyAmountsByCategoriesPerUser(String user, int month, int year) {
        return TRANSACTION_CACHE.stream()
                .filter(transaction -> transaction.getUser().equals(user) &&
                        transaction.getDate().getMonth().getValue() == month &&
                        transaction.getDate().getYear() == year)
                .collect(groupingBy(Transaction::getCategory, summingDouble(Transaction::getAmount)));
    }

    public Map<Category, Double> getYearlyAmountsByCategoriesPerUser(String user, int year) {
        return TRANSACTION_CACHE.stream()
                .filter(transaction -> transaction.getUser().equals(user) &&
                        transaction.getDate().getYear() == year)
                .collect(groupingBy(Transaction::getCategory, summingDouble(Transaction::getAmount)));
    }
}
