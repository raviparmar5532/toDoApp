package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Data
public class TaskDto {
	private Integer taskId;
	private String taskName;
	@JsonIgnore
	private PersonDto person;
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public PersonDto getPerson() {
		return person;
	}
	public void setPerson(PersonDto person) {
		this.person = person;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}	
}
