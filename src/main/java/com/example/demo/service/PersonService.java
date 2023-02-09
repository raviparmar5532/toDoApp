package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PersonDto;
import com.example.demo.dto.ProjectDto;
import com.example.demo.dto.TaskDto;

public interface PersonService {

//	Retrive all Person list
	public List<PersonDto> getAllPerson() ;
//	Add new Person
	public String addPerson(PersonDto p) ;
//	Person detail by Person id
	public String getPersonById(Integer id) ;
//	deleting a Person by id
	public String deleteById(Integer id) ;
//	Assigning a task to person
	public String addTask(Integer id, TaskDto t) ;
//	Listing of tasks assigned to a person
	public List<TaskDto> getTasks(Integer id) ;
//	Assign project
	public String assignProject(Integer personId, ProjectDto project) ;
//	Remove project	
	public String removeProject(Integer personId, Integer projectId) ;
//	Get assigned projects
	public List<ProjectDto> getProjects(Integer personId) ;
}
