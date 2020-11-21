package com.ing.pandemaniacs.hackathon;

import com.ing.pandemaniacs.hackathon.parser.CSVParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TransactionsVisualizerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TransactionsVisualizerApplication.class, args);
	}

}
