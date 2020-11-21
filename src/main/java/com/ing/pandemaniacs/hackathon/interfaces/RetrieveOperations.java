package com.ing.pandemaniacs.hackathon.interfaces;

import com.ing.pandemaniacs.hackathon.model.Transaction;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface RetrieveOperations {

    @GetMapping("/all")
    List<Transaction> getAll();

}
