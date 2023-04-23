package com.svyatdanilov.investmentproject.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

@Component
public class CsvReaderImpl implements CsvReader {

    public CsvReaderImpl() {
    }

    @Override
    public List<String> csvLineParsing(String csvLine) throws CsvValidationException, IOException {
        CSVReader reader = new CSVReader(new StringReader(csvLine));
        String[] temp = reader.readNext();
        return Arrays.asList(temp);
    }

}
