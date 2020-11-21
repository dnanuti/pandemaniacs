package com.ing.pandemaniacs.hackathon.controllers;

import com.ing.pandemaniacs.hackathon.interfaces.RetrieveOperations;
import com.ing.pandemaniacs.hackathon.model.Transaction;
import com.ing.pandemaniacs.hackathon.parser.CSVParser;
import com.ing.pandemaniacs.hackathon.services.PaginationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ing.pandemaniacs.hackathon.TransactionsVisualizerApplication.TRANSACTION_CACHE;

@RestController
@RequestMapping("/retrieve")
public class RetrieveController implements RetrieveOperations {
    private final PaginationService paginationService;

    public RetrieveController(final PaginationService paginationService) {
        this.paginationService = paginationService;
    }

    @Override
    public List<Transaction> getAll() {
        return TRANSACTION_CACHE;
    }


    @Override
    public String getAllAsCSV() {
        return new CSVParser().transactionListToCSV(TRANSACTION_CACHE);
    }

    @Override
    public List<Transaction> getAllPaginated(int page, int size) {
        return paginationService.getPaginatedTransactions(TRANSACTION_CACHE, page, size);
    }

    @Override
    public String getAllAsCSVPaginated(int page, int size) {
        return paginationService.getPaginatedTransactionsAsCSV(TRANSACTION_CACHE, page, size);
    }
}
