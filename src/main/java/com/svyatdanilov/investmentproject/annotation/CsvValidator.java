package com.svyatdanilov.investmentproject.annotation;


import com.opencsv.exceptions.CsvValidationException;
import com.svyatdanilov.investmentproject.csv.CsvReader;
import com.svyatdanilov.investmentproject.dto.ProjectDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;


public class CsvValidator implements ConstraintValidator<CsvValidation, ProjectDto>
{

    private CsvReader csvReader;

    @Autowired
    public CsvValidator(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public boolean isValid(ProjectDto projectDto, ConstraintValidatorContext constraintValidatorContext) {
        try {
            return checkAllNumbersOrNotInCsvLine(projectDto.getProfit_per_unit_of_the_implementation_period())
                    && checkQuantityOfElementsInCsvLine(projectDto.getProfit_per_unit_of_the_implementation_period(),
                    projectDto.getImplementation_period());
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    private boolean checkQuantityOfElementsInCsvLine(String csvLine, int expectedQuantityOfElements) throws CsvValidationException, IOException {
        return csvReader.csvLineParsing(csvLine).size() == expectedQuantityOfElements;
    }


    private boolean checkAllNumbersOrNotInCsvLine(String csvLine) throws CsvValidationException, IOException {
        return csvReader.csvLineParsing(csvLine).stream().allMatch(this::isDigit);
    }


    private boolean isDigit(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



}
