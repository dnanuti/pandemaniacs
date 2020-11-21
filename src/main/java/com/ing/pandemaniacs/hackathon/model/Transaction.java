package com.ing.pandemaniacs.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.ing.pandemaniacs.hackathon.model.Category.fromValue;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.time.LocalDateTime.parse;

@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

    private String user;
    private LocalDateTime date;
    private String description;
    private Double amount;
    private Category category;
    private String location;
    private Double latitude;
    private Double longitude;

    public Transaction(String line) {
        String[] transactionData = line.split(";");
        user = transactionData[0];
        date = parse(transactionData[1],formatter);
        description = transactionData[2];
        amount = parseDouble(transactionData[3].replace(".","")) / 100;
        category = fromValue(transactionData[4]);
        location = transactionData[5];
        latitude = parseDouble(transactionData[6]);
        longitude = parseDouble(transactionData[7]);
    }

    private LocalDateTime parseDate(String[] auxDate) {
        String dateToParse = (auxDate[0].length() == 9) ? "0" + auxDate[0] : auxDate[0];
        String timeToParse = (auxDate[1].length() == 4) ? "0" + auxDate[1] : auxDate[1];

        return parse(dateToParse + " " + timeToParse, formatter);
    }

    @Override
    public String toString() {
        return format("%s,%s,%s,%s,%s,%s,%s,%s", user, date, description, amount, category, location, latitude, longitude);
    }
}
