package com.ing.pandemaniacs.hackathon.services;

import com.ing.pandemaniacs.hackathon.model.Transaction;
import com.ing.pandemaniacs.hackathon.parser.CSVParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaginationService {

    public List<Transaction> getPaginatedTransactions(List<Transaction> transactions, int page, int size) {
        int start = page * size;
        int end = start + size - 1;

        if (transactions == null
                || (start > end) || (end > transactions.size())
                || (start < 0) || (end < 0)) {
            throw new IllegalArgumentException("Invalid page number and / or size");
        }

        List<Transaction> result = new ArrayList<>();
        for (int i = start; i <= end; ++i) {
            result.add(transactions.get(i));
        }
        return result;
    }

    public String getPaginatedTransactionsAsCSV(List<Transaction> transactions, int page, int size) {
        return new CSVParser().transactionListToCSV(getPaginatedTransactions(transactions, page, size));
    }
}
