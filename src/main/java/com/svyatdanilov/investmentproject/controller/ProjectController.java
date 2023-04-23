package com.svyatdanilov.investmentproject.controller;

import com.opencsv.exceptions.CsvValidationException;
import com.svyatdanilov.investmentproject.dto.ProjectDto;
import com.svyatdanilov.investmentproject.service.ProjectDtoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	private ProjectDtoService projectService;

	@Autowired
	public ProjectController(ProjectDtoService projectService) {
		this.projectService = projectService;
	}

	@GetMapping("/list")
	public String listProjects(Model model) throws CsvValidationException, IOException {
		List<ProjectDto> projectDtoList = projectService.findAll();
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
	public String saveEmployee(@Valid ProjectDto projectDto, BindingResult result) {
		if (result.hasErrors()) {
			return "projects/project-form";
		}
		projectService.save(projectDto);
		return "redirect:/projects/list";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("projectId") int id) {
		projectService.deleteById(id);
		return "redirect:/projects/list";
	}


}









