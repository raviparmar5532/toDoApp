package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PersonDto;
import com.example.demo.dto.ProjectDto;
import com.example.demo.service.serviceimpl.ProjectServiceImpl;

@RestController
public class ProjectController {
	@Autowired
	private ProjectServiceImpl projectService;
	
	
	@GetMapping(value = "projects")
	public ResponseEntity<List<ProjectDto>> getAllProjects() {
		return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
	}
	
	@GetMapping(value = "projects/persons")
	public ResponseEntity<List<PersonDto>> getPersons(@RequestParam("projectname") String projectName) {
		return new ResponseEntity<>(projectService.getPersons(projectName), HttpStatus.OK);
	}
	
	@PostMapping(value = "projects")
	public ResponseEntity<Map<String, String>> addProject(@RequestBody ProjectDto p) {
		Map<String, String>mp = new HashMap<>();
		mp.put("Response", projectService.addProject(p));
		return new ResponseEntity<>(mp, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "projects/{id}")
	public ResponseEntity<Map<String, String>> deleteProject(@PathVariable("id") Integer id) {
		Map<String, String>mp = new HashMap<>();
		mp.put("Response", projectService.deleteProject(id));
		return new ResponseEntity<>(mp, HttpStatus.OK);
	}
	
	@PostMapping(value = "projects/{projectId}/persons")
	public ResponseEntity<Map<String, String>> addPerson(@PathVariable("projectId") Integer projectId, @RequestBody PersonDto p) {
		Map<String, String>mp = new HashMap<>();
		mp.put("Response", projectService.addPerson(projectId, p));
		return new ResponseEntity<>(mp, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "projects/{projectId}/persons/{personId}")
	public ResponseEntity<Map<String, String>> removePerson(@PathVariable("projectId") Integer projectId, @PathVariable("personId") Integer personId) {
		Map<String, String>mp = new HashMap<>();
		mp.put("Response", projectService.removePerson(projectId, personId));
		return new ResponseEntity<>(mp, HttpStatus.OK);
	}
}
