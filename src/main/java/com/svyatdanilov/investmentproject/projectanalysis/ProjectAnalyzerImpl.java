package com.svyatdanilov.investmentproject.projectanalysis;

import com.opencsv.exceptions.CsvValidationException;
import com.svyatdanilov.investmentproject.csv.CsvReader;
import com.svyatdanilov.investmentproject.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectAnalyzerImpl implements ProjectAnalyzer {

    private final CsvReader csvReader;

    @Autowired
    public ProjectAnalyzerImpl(CsvReader csvReader) {
        this.csvReader=csvReader;
    }

    @Override
    public String analysis(ProjectDto projectDto) throws CsvValidationException, IOException {
        if(netPresentValueAnalysis(projectDto) && internalRateOfReturnValueAnalysis(projectDto) &&
        profitabilityIndexValueAnalysis(projectDto)){
            return "Subject to implementation";
        }
        else{
            return "Not subject to implementation";
        }
    }

    private boolean netPresentValueAnalysis(ProjectDto projectDto) throws CsvValidationException, IOException {
        List<Double> profit_per_unit_of_the_implementation_period = csvReader.
                csvLineParsing(projectDto.getProfit_per_unit_of_the_implementation_period())
                .stream().map(Double::parseDouble).collect(Collectors.toList());
        double sum = 0;
        for(int t = 1; t <= projectDto.getImplementation_period(); t++)
        {
            sum = sum + profit_per_unit_of_the_implementation_period.get(t-1)/Math.pow((1+projectDto.getDiscount_rate()),t);
        }
        sum = sum - projectDto.getInitial_investment();
        return sum > 0;
    }

    private boolean internalRateOfReturnValueAnalysis(ProjectDto projectDto) throws CsvValidationException, IOException {
        List<Double> profit_per_unit_of_the_implementation_period = csvReader.
                csvLineParsing(projectDto.getProfit_per_unit_of_the_implementation_period())
                .stream().map(Double::parseDouble).collect(Collectors.toList());
        double sum = 0;
        for(int t = 1; t <= projectDto.getImplementation_period(); t++)
        {
            sum = sum + profit_per_unit_of_the_implementation_period.get(t-1)/projectDto.getInitial_investment();
        }
        sum = sum - 1;
        return Math.pow(sum,1/projectDto.getImplementation_period()) > projectDto.getLoan_interest_rate();
    }

    private boolean profitabilityIndexValueAnalysis(ProjectDto projectDto) throws CsvValidationException, IOException {
        List<Double> profit_per_unit_of_the_implementation_period = csvReader.
                csvLineParsing(projectDto.getProfit_per_unit_of_the_implementation_period())
                .stream().map(Double::parseDouble).collect(Collectors.toList());
        double sum = 0;
        for(int t = 1; t <= projectDto.getImplementation_period(); t++)
        {
            sum = sum + profit_per_unit_of_the_implementation_period.get(t-1)/Math.pow((1+projectDto.getDiscount_rate()),t);
        }
        sum = sum - projectDto.getInitial_investment();
        return sum/projectDto.getInitial_investment() > 1;
    }



}
