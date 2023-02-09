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
import com.example.demo.mapper.MapstructMapper;
import com.example.demo.model.Person;
import com.example.demo.model.Project;
import com.example.demo.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private PersonServiceImpl personService;
	@Autowired
	private MapstructMapper mp;
	public String addProject(ProjectDto p) {
		try {
			projectDao.save(mp.projectDtoToProject(p));
			return "Project added";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public String deleteProject(Integer id) {
		try {
			if(projectDao.existsById(id)) {
				projectDao.deleteById(id);		
				return "Project removed";
			}
			else return "No Project with ID = "+id+" exists";
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	public List<ProjectDto> getAllProjects() {
		return projectDao.findAll().stream().map(pro -> mp.projectToProjectDto(pro)).collect(Collectors.toList());
	}
	public List<PersonDto> getPersons(String name) {
		for(Project p : projectDao.findAll()) {
			if(p.getProjectName().equals(name)) {
				return p.getPersons().stream().map(per -> mp.personToPersonDto(per)).collect(Collectors.toList());
			}
		}
		return new ArrayList<>();
	}
	public String addPerson(Integer projectId, PersonDto per) {
		try {
			Person person = mp.personDtoToPerson(per);
			Integer personId = personDao.save(person).getPersonId();
			personService.assignProject(personId, mp.projectToProjectDto(projectDao.getReferenceById(projectId)));
			return "Person added";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public String removePerson(Integer projectId, Integer personId) {
		try {
			personService.removeProject(personId, projectId);
			return "Person Removed";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
