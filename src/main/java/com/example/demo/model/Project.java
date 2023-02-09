package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity @DynamicUpdate @Table(name = "project")
public class Project {
	public Project() {
		persons = new ArrayList<>();
	}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "project_id") 
	private Integer projectId;
	@Column(name = "project_name")
	private String projectName;
	@ManyToMany(mappedBy = "projects")
	public List<Person>persons;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Person> getPersons() {
		if(persons == null) return new ArrayList<>();
		return this.persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", persons=" + persons.size() + "]";
	}
	
}
