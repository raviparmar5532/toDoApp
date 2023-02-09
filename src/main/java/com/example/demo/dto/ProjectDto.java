package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProjectDto {
	private Integer projectId;
	private String projectName;
	@JsonIgnore
	private List<PersonDto>persons;
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
}
