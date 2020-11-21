package com.ing.pandemaniacs.hackathon;

import com.ing.pandemaniacs.hackathon.model.Category;
import com.ing.pandemaniacs.hackathon.model.Transaction;
import com.ing.pandemaniacs.hackathon.parser.CSVParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.ing.pandemaniacs.hackathon.TransactionsVisualizerApplication.TRANSACTION_CACHE;
import static com.ing.pandemaniacs.hackathon.parser.CSVParser.DEFAULT_PATH;
import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class CSVParserTest {

    @Test
    public void testParsing() throws IOException {
        List<Transaction> transactionList = new CSVParser().parseTransactions(DEFAULT_PATH);
        assertNotNull(transactionList);
        assertEquals("Vitsy", transactionList.get(0).getUser());
    }

    @Test
    public void testParsing2() throws IOException {
        List<Transaction> transactionList = new CSVParser().parseTransactions(DEFAULT_PATH);
        Map<Category, Double> userTransactions = transactionList.stream()
                .filter(transaction -> transaction.getUser().equals("Hunter Lott") &&
                        transaction.getDate().getMonth().getValue() == 10 &&
                        transaction.getDate().getYear() == 2019)
                .collect(groupingBy(Transaction::getCategory, summingDouble(Transaction::getAmount)));
        System.out.println(userTransactions);
    }
}
