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
import com.example.demo.dto.TaskDto;
import com.example.demo.service.serviceimpl.PersonServiceImpl;

@RestController
public class PersonController {
	@Autowired
	private PersonServiceImpl personService;
	@GetMapping(value = "persons")
	public List<PersonDto>getAllPerson() {
		return personService.getAllPerson();
	}
	@GetMapping(value = "persons/{id}")
	public String getPersonById(@PathVariable("id") Integer id) {
		return personService.getPersonById(id);
	}
	@PostMapping(value = "persons") 
	public String addPerson(@RequestBody PersonDto p) {
		return personService.addPerson(p);
	}
	@DeleteMapping(value = "persons/{id}") 
	public String deleteById(@PathVariable("id") Integer id) {
		return personService.deleteById(id);
	}
	@PostMapping(value = "persons/{id}/tasks")
	public String addTask(@PathVariable("id") Integer id, @RequestBody TaskDto t) {
		return personService.addTask(id, t);
	}
	@GetMapping(value = "persons/{id}/tasks")
	public List<TaskDto>getTasks(@PathVariable("id") Integer id) {
		return personService.getTasks(id);
	}
	@PostMapping(value = "persons/{id}/projects")
	public String addProject(@PathVariable("id") Integer personId, @RequestBody ProjectDto p) {
		return personService.assignProject(personId, p);
	}
	@GetMapping(value = "persons/{id}/projects")
	public List<ProjectDto> getAssignedProjects(@PathVariable("id") Integer id) {
		return personService.getProjects(id);
	}
	@DeleteMapping(value = "persons/{personId}/projects/{projectId}")
	public String deleteProject(@PathVariable("personId") Integer personId, @PathVariable("projectId") Integer projectId) {
		return personService.removeProject(personId, projectId);
	}
}
