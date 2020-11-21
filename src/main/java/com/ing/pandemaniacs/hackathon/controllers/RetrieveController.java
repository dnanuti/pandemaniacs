package com.ing.pandemaniacs.hackathon.controllers;

import com.ing.pandemaniacs.hackathon.interfaces.RetrieveOperations;
import com.ing.pandemaniacs.hackathon.model.Transaction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ing.pandemaniacs.hackathon.TransactionsVisualizerApplication.TRANSACTION_CACHE;

@RestController
@RequestMapping("/retrieve")
public class RetrieveController implements RetrieveOperations {
    @Override
    public List<Transaction> getAll() {
        return TRANSACTION_CACHE;
    }
}
