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
	public ResponseEntity<List<PersonDto>>getAllPerson() {
		return new ResponseEntity<List<PersonDto>>(personService.getAllPerson(), HttpStatus.OK);
	}
	@GetMapping(value = "persons/{id}")
	public ResponseEntity<Map<String, Object>> getPersonById(@PathVariable("id") Integer id) {
		Map<String, Object>mp = new HashMap<>();
		mp.put("Response", personService.getPersonById(id));
		return new ResponseEntity<Map<String, Object>>(mp, HttpStatus.OK);
	}
	@PostMapping(value = "persons") 
	public ResponseEntity<Map<String, Object>> addPerson(@RequestBody PersonDto p) {
		Map<String, Object>mp = new HashMap<>();
		mp.put("Response", personService.addPerson(p));
		return new ResponseEntity<Map<String, Object>>(mp, HttpStatus.CREATED);
	}
	@DeleteMapping(value = "persons/{id}") 
	public ResponseEntity<Map<String, String>> deleteById(@PathVariable("id") Integer id) {
		Map<String, String>mp = new HashMap<>();
		mp.put("Response", personService.deleteById(id));
		return new ResponseEntity<Map<String, String>>(mp, HttpStatus.OK);
	}
	@PostMapping(value = "persons/{id}/tasks")
	public ResponseEntity<Map<String, String>> addTask(@PathVariable("id") Integer id, @RequestBody TaskDto t) {
		Map<String, String>mp = new HashMap<>();
		mp.put("Response", personService.addTask(id, t));
		return new ResponseEntity<Map<String, String>>(mp, HttpStatus.CREATED);
	}
	@GetMapping(value = "persons/{id}/tasks")
	public ResponseEntity<List<TaskDto>> getTasks(@PathVariable("id") Integer id) {
		return new ResponseEntity<List<TaskDto>>(personService.getTasks(id), HttpStatus.OK);
	}
	@PostMapping(value = "persons/{id}/projects")
	public ResponseEntity<Map<String, String>> addProject(@PathVariable("id") Integer personId, @RequestBody ProjectDto p) {
		Map<String, String>mp = new HashMap<>();
		mp.put("Response", personService.assignProject(personId, p));
		return new ResponseEntity<Map<String,String>>(mp, HttpStatus.OK);
	}
	@GetMapping(value = "persons/{id}/projects")
	public ResponseEntity<List<ProjectDto>> getAssignedProjects(@PathVariable("id") Integer id) {
		return new ResponseEntity<List<ProjectDto>>(personService.getProjects(id), HttpStatus.OK);
	}
	@DeleteMapping(value = "persons/{personId}/projects/{projectId}")
	public ResponseEntity<Map<String, String>> deleteProject(@PathVariable("personId") Integer personId, @PathVariable("projectId") Integer projectId) {
		Map<String, String>mp = new HashMap<>();
		mp.put("Response", personService.removeProject(personId, projectId));
		return new ResponseEntity<Map<String,String>>(mp, HttpStatus.OK);
	}
}
