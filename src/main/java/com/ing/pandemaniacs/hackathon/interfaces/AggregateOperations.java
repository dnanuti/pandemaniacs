package com.ing.pandemaniacs.hackathon.interfaces;

import com.ing.pandemaniacs.hackathon.model.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/aggregate")
public interface AggregateOperations {

    // Monthly report per user with amounts sums per category
    @GetMapping("/monthly/{user}")
    List<Transaction> getAll();

}