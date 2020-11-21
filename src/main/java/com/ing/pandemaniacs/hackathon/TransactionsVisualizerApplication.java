package com.ing.pandemaniacs.hackathon;

import com.ing.pandemaniacs.hackathon.model.Transaction;
import com.ing.pandemaniacs.hackathon.parser.CSVParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

import static com.ing.pandemaniacs.hackathon.parser.CSVParser.DEFAULT_PATH;

@SpringBootApplication
public class TransactionsVisualizerApplication {

	public static List<Transaction> TRANSACTION_CACHE;

	public static void main(String[] args) throws IOException {
		TRANSACTION_CACHE = new CSVParser().parseTransactions(DEFAULT_PATH);
		SpringApplication.run(TransactionsVisualizerApplication.class, args);
	}

}
