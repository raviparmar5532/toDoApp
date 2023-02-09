package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@DynamicUpdate
@Table(name = "person")
public class Person {
	public Person() {
		tasks = new ArrayList<>();
		projects = new ArrayList<>();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private Integer personId;
	@Column(name = "person_name")	
	private String personName;
	@OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL) 
	private List<Task>tasks;
	@ManyToMany
	@JoinTable(
			name = "person_project",
			joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"),
			inverseJoinColumns =  @JoinColumn(name = "project_id", referencedColumnName = "project_id")
		)
	private List<Project>projects; 
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	
	public void addTask(Task t) {
		this.tasks.add(t);
		t.setPerson(this);
	}
	public void removeTask(Task t) {
		this.tasks.remove(t);
		t.setPerson(null);
	}
	public void addProject(Project p) {
		if(this.projects == null) projects = new ArrayList<>();
		this.projects.add(p);
		p.getPersons().add(this);
	}
	public void removeProject(Project p) {
		this.projects.remove(p);
		p.getPersons().remove(this);
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", tasks=" + tasks.size() + ", projects = " + projects.size() + "]";
	}
}