package com.svyatdanilov.investmentproject.service;

import com.opencsv.exceptions.CsvValidationException;
import com.svyatdanilov.investmentproject.dto.ProjectDto;

import java.io.IOException;
import java.util.List;

public interface ProjectDtoService {

	List<ProjectDto> findAll(String userEmail) throws CsvValidationException, IOException;
	
	ProjectDto findById(int id);

	void save (ProjectDto projectDto,String userEmail);

	void deleteById(int id);
	
}
