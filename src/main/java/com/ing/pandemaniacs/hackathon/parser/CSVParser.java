package com.ing.pandemaniacs.hackathon.parser;

import com.ing.pandemaniacs.hackathon.model.Transaction;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;
import static java.util.stream.Collectors.toList;

public class CSVParser {
    public static final String DEFAULT_PATH = "src/main/resources/data.csv";
    public static final String HEADERS = "User,Date,Description,Amount,Category,Location,Latitude,Longitude";

    public List<Transaction> parseTransactions(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        try (Stream<String> csvLines = lines(path)) {
            return csvLines.map(Transaction::new).collect(toList());
        }
    }
}
