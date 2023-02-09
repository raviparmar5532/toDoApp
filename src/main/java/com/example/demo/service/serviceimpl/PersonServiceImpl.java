package com.example.demo.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.dao.ProjectDao;
import com.example.demo.dto.PersonDto;
import com.example.demo.dto.ProjectDto;
import com.example.demo.dto.TaskDto;
import com.example.demo.mapper.MapstructMapper;
import com.example.demo.model.Person;
import com.example.demo.model.Project;
import com.example.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private MapstructMapper mp;
	
//	Retrieve all Person list
	public List<PersonDto> getAllPerson() {
		return personDao.findAll().stream().map(p -> mp.personToPersonDto(p)).collect(Collectors.toList());
	}
//	Add new Person
	public String addPerson(PersonDto p) {
		try {
			personDao.save(mp.personDtoToPerson(p));
			return "Person added";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
//	Person detail by Person id
	public String getPersonById(Integer id) {
		try {
			return personDao.getReferenceById(id).toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
//	deleting a Person by id
	public String deleteById(Integer id) {
		try {
			if(personDao.existsById(id)) {
				personDao.deleteById(id);		
				return "Person removed";
			}
			else return "No Person with ID = "+id+" exists";
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
//	Assigning a task to person
	public String addTask(Integer id, TaskDto t) {
		try {
			Person p = personDao.getReferenceById(id);
			p.addTask(mp.taskDtoTotask(t));
			personDao.save(p);
			return "Task added";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
//	Listing of tasks assigned to a person
	public List<TaskDto> getTasks(Integer id) {
		if(personDao.existsById(id)) {
			return personDao.getReferenceById(id).getTasks().stream().map(t -> mp.taskToTaskDto(t)).collect(Collectors.toList());			
		}else {
			return new ArrayList<>();
		}
	}
//	Assign project
	public String assignProject(Integer personId, ProjectDto pdto) {
		try {
			Person person = personDao.getReferenceById(personId);
			Project p = mp.projectDtoToProject(pdto);
			person.addProject(p);
			projectDao.save(p);
			personDao.save(person);
			return "Project added";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
//	Remove project	
	public String removeProject(Integer personId, Integer projectId) {
		try {
			Person per = personDao.getReferenceById(personId);
			Project pro = projectDao.getReferenceById(projectId);
			if(!per.getProjects().contains(pro)) return "Person is not working on project"; 
			per.removeProject(pro);
			personDao.save(per);
			return "Project Removed";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
//	Get assigned projects
	public List<ProjectDto> getProjects(Integer personId) {
		try {
			return personDao.getReferenceById(personId).getProjects().stream().map(p -> mp.projectToProjectDto(p)).collect(Collectors.toList());
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
}
