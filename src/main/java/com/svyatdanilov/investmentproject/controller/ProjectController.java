package com.svyatdanilov.investmentproject.controller;

import com.opencsv.exceptions.CsvValidationException;
import com.svyatdanilov.investmentproject.dao.ProjectRepository;
import com.svyatdanilov.investmentproject.dao.UserRepository;
import com.svyatdanilov.investmentproject.dto.ProjectDto;
import com.svyatdanilov.investmentproject.entity.Project;
import com.svyatdanilov.investmentproject.projectanalysis.ProjectAnalyzer;
import com.svyatdanilov.investmentproject.service.ProjectDtoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	private ProjectDtoService projectService;
	private ProjectAnalyzer projectAnalyzer;
	private UserRepository userRepository;
	private ProjectRepository projectRepository;

	@Autowired
	public ProjectController(ProjectDtoService projectService, ProjectAnalyzer projectAnalyzer,
							 UserRepository userRepository, ProjectRepository projectRepository) {
		this.projectService = projectService;
		this.projectAnalyzer = projectAnalyzer;
		this.userRepository = userRepository;
		this.projectRepository = projectRepository;
	}

	@GetMapping("/list")
	public String listProjects(HttpServletRequest request,Model model) throws CsvValidationException, IOException {
		List<ProjectDto> projectDtoList = new ArrayList<>();
		ProjectDto projectDtoTemp = null;
		for (Project projectTemp: userRepository.findByEmail(request.getUserPrincipal().getName()).getProjects()){
			projectDtoTemp = new ProjectDto();
			BeanUtils.copyProperties(projectTemp,projectDtoTemp);
			projectDtoTemp.setConclusion(projectAnalyzer.analysis(projectDtoTemp));
			projectDtoList.add(projectDtoTemp);
		}
		model.addAttribute("projectDtoList", projectDtoList);
		return "projects/list-projects";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		ProjectDto projectDto = new ProjectDto();
		model.addAttribute("projectDto", projectDto);
		return "projects/project-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("projectId") int id, Model model) {
		ProjectDto projectDto = projectService.findById(id);
		model.addAttribute("projectDto", projectDto);
		return "projects/project-form";
	}


	@PostMapping("/save")
	public String saveEmployee(@Valid ProjectDto projectDto, BindingResult result,
							   HttpServletRequest httpServletRequest) {
		if (result.hasErrors()) {
			return "projects/project-form";
		}
		Project project = new Project();
		BeanUtils.copyProperties(projectDto,project);
		project.setUser(userRepository.findByEmail(httpServletRequest.getUserPrincipal().getName()));
		projectRepository.save(project);
		return "redirect:/projects/list";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("projectId") int id) {
		projectService.deleteById(id);
		return "redirect:/projects/list";
	}


}









