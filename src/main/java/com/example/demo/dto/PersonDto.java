package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonDto {
	private Integer personId;
	private String personName;
	@JsonIgnore
	private List<TaskDto>tasks;
	@JsonIgnore
	private List<ProjectDto>projects;
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
}
