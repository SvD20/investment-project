package com.svyatdanilov.investmentproject.service;


import com.opencsv.exceptions.CsvValidationException;
import com.svyatdanilov.investmentproject.dao.ProjectRepository;
import com.svyatdanilov.investmentproject.dao.UserRepository;
import com.svyatdanilov.investmentproject.dto.ProjectDto;
import com.svyatdanilov.investmentproject.entity.Project;
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
	private final UserRepository userRepository;


	@Autowired
	public ProjectDtoServiceImpl(ProjectRepository projectRepository, ProjectAnalyzer projectAnalyzer,
								 UserRepository userRepository) {
		this.projectRepository = projectRepository;
		this.projectAnalyzer = projectAnalyzer;
		this.userRepository = userRepository;
	}

	@Override
	public List<ProjectDto> findAll(String userEmail) throws CsvValidationException, IOException {
		List<ProjectDto> projectDtoList = new ArrayList<>();
		ProjectDto projectDtoTemp = null;
		for (Project projectTemp: userRepository.findByEmail(userEmail).getProjects()){
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
	public void save(ProjectDto projectDto,String userEmail) {
		Project project = new Project();
		BeanUtils.copyProperties(projectDto,project);
		project.setUser(userRepository.findByEmail(userEmail));
		projectRepository.save(project);
	}

	@Override
	public void deleteById(int id) {
		projectRepository.deleteById(id);
	}

}






