package com.svyatdanilov.investmentproject.csv;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.List;


public interface CsvReader {

    List<String> csvLineParsing(String csvLine) throws CsvValidationException, IOException;

}
