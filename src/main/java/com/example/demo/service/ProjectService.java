package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PersonDto;
import com.example.demo.dto.ProjectDto;

public interface ProjectService {
	public String addProject(ProjectDto p) ;
	public String deleteProject(Integer id) ;
	public List<ProjectDto> getAllProjects() ;
	public List<PersonDto> getPersons(String name) ;
	public String removePerson(Integer projectId, Integer personId) ;
	public String addPerson(Integer projectId, PersonDto per) ;
	public String addPersonQuery(Integer projectId, PersonDto per) ;
}
