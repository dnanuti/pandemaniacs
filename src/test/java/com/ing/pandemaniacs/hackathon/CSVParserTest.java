package com.ing.pandemaniacs.hackathon;

import com.ing.pandemaniacs.hackathon.model.Transaction;
import com.ing.pandemaniacs.hackathon.parser.CSVParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

import static com.ing.pandemaniacs.hackathon.parser.CSVParser.DEFAULT_PATH;
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
}
