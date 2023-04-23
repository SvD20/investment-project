package com.svyatdanilov.investmentproject.projectanalysis;

import com.opencsv.exceptions.CsvValidationException;
import com.svyatdanilov.investmentproject.dto.ProjectDto;
import org.springframework.stereotype.Component;

import java.io.IOException;


public interface ProjectAnalyzer {

    String analysis(ProjectDto projectDto) throws CsvValidationException, IOException;

}
