package com.ing.pandemaniacs.hackathon.model;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.ing.pandemaniacs.hackathon.model.Category.fromValue;
import static java.lang.Float.parseFloat;
import static java.time.LocalDateTime.parse;

@AllArgsConstructor
public class Transaction {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");

    String user;
    LocalDateTime date;
    String description;
    float amount;
    Category category;
    String location;
    float latitude;
    float longitude;

    public Transaction(String line) {
        String[] transactionData = line.split(",");
        user = transactionData[0];
        date = parseDate(transactionData[1].split(" "));
        description = transactionData[2];
        amount = parseFloat(transactionData[3]);
        category = fromValue(transactionData[4]);
        location = transactionData[5];
        latitude = parseFloat(transactionData[6]);
        longitude = parseFloat(transactionData[7]);
    }

    private LocalDateTime parseDate(String[] auxDate) {
        String dateToParse = (auxDate[0].length() == 9) ? "0" + auxDate[0] : auxDate[0];
        String timeToParse = (auxDate[1].length() == 4) ? "0" + auxDate[1] : auxDate[1];

        return parse(dateToParse + " " + timeToParse, formatter);
    }
}