package com.svyatdanilov.investmentproject.service;

import com.opencsv.exceptions.CsvValidationException;
import com.svyatdanilov.investmentproject.dto.ProjectDto;

import java.io.IOException;
import java.util.List;

public interface ProjectDtoService {

	List<ProjectDto> findAll() throws CsvValidationException, IOException;
	
	ProjectDto findById(int id);
	
	void save(ProjectDto projectDto);
	
	void deleteById(int id);
	
}
