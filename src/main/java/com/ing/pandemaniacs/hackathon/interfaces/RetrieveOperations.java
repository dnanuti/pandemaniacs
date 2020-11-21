package com.ing.pandemaniacs.hackathon.interfaces;

import com.ing.pandemaniacs.hackathon.model.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RetrieveOperations {

    // Get all transactions as JSON
    @GetMapping(value = "/all")
    List<Transaction> getAll();

    // Get all transactions as JSON paginated
    @GetMapping(value = "/all", params = {"page", "size"})
    List<Transaction> getAllPaginated(@RequestParam("page") int page,
                                      @RequestParam("size") int size);

    // Get CSV formatted String
    @GetMapping(value = "/all/csv")
    String getAllAsCSV();

    // Get CSV formatted String paginated
    @GetMapping(value = "/all/csv", params = {"page", "size"})
    String getAllAsCSVPaginated(@RequestParam("page") int page,
                                @RequestParam("size") int size);
}
