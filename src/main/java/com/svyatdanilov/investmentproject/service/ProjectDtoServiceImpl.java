package com.svyatdanilov.investmentproject.service;


import com.opencsv.exceptions.CsvValidationException;
import com.svyatdanilov.investmentproject.dao.ProjectRepository;
import com.svyatdanilov.investmentproject.dto.ProjectDto;
import com.svyatdanilov.investmentproject.entity.Project;
import com.svyatdanilov.investmentproject.entity.User;
import com.svyatdanilov.investmentproject.projectanalysis.ProjectAnalyzer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProjectDtoServiceImpl implements ProjectDtoService {

	private final ProjectRepository projectRepository;
	private final ProjectAnalyzer projectAnalyzer;

	@Autowired
	public ProjectDtoServiceImpl(ProjectRepository projectRepository, ProjectAnalyzer projectAnalyzer) {
		this.projectRepository = projectRepository;
		this.projectAnalyzer = projectAnalyzer;
	}

	@Override
	public List<ProjectDto> findAll() throws CsvValidationException, IOException {
		List <Project> projectList = projectRepository.findAll();
		List<ProjectDto> projectDtoList = new ArrayList<>();
		ProjectDto projectDtoTemp = null;
		for (Project projectTemp: projectList){
			projectDtoTemp = new ProjectDto();
			BeanUtils.copyProperties(projectTemp,projectDtoTemp);
			projectDtoTemp.setConclusion(projectAnalyzer.analysis(projectDtoTemp));
			projectDtoList.add(projectDtoTemp);
		}
		return projectDtoList;
	}

	@Override
	public ProjectDto findById(int id) {
		Optional<Project> result = projectRepository.findById(id);
		Project project = null;
		if (result.isPresent()) {
			project = result.get();
		}
		else {
			throw new RuntimeException("Did not find project id - " + id);
		}
		ProjectDto projectDto = new ProjectDto();
		BeanUtils.copyProperties(project,projectDto);
		return projectDto;
	}

	@Override
	public void save(ProjectDto projectDto) {
		Project project = new Project();
		BeanUtils.copyProperties(projectDto,project);
		projectRepository.save(project);
	}

	@Override
	public void deleteById(int id) {
		projectRepository.deleteById(id);
	}

}






