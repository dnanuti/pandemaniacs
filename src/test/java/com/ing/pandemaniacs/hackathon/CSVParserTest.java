package com.ing.pandemaniacs.hackathon;

import com.ing.pandemaniacs.hackathon.parser.CSVParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
public class CSVParserTest {

    @Test
    public void testParsing() throws IOException {
        new CSVParser().parseTransaction(CSVParser.DEFAULT_PATH);
    }
}
