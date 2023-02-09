package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PersonDto;
import com.example.demo.dto.ProjectDto;
import com.example.demo.service.serviceimpl.ProjectServiceImpl;

@RestController
public class ProjectController {
	@Autowired
	private ProjectServiceImpl projectService;
	@GetMapping(value = "projects")
	public List<ProjectDto> getAllProjects() {
		return projectService.getAllProjects();
	}
	@GetMapping(value = "projects/{projectName}/persons")
	public List<PersonDto> getPersons(@PathVariable("projectName") String projectName) {
		return projectService.getPersons(projectName);
	}
	@PostMapping(value = "projects")
	public String addProject(@RequestBody ProjectDto p) {
		return projectService.addProject(p);
	}
	@DeleteMapping(value = "projects/{id}")
	public String deleteProject(@PathVariable("id") Integer id) {
		return projectService.deleteProject(id);
	}
	@PostMapping(value = "projects/{projectId}/persons")
	public String addPerson(@PathVariable("projectId") Integer projectId, @RequestBody PersonDto p) {
		return projectService.addPerson(projectId, p);
	}
	@DeleteMapping(value = "projects/{projectId}/persons/{personId}")
	public String removePerson(@PathVariable("projectId") Integer projectId, @PathVariable("personId") Integer personId) {
		return projectService.removePerson(projectId, personId);
	}
}
