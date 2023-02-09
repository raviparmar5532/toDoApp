package com.example.demo.model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicUpdate
@Table(name = "task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private Integer taskId;
	@Column(name = "task_name")
	private String taskName;
	@ManyToOne(optional = false)
	@JsonIgnore
	@JoinColumn(
		name = "person_id",
		referencedColumnName = "person_id"
	)
	private Person person;
	
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String name) {
		this.taskName = name;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", person=" + person.getPersonId() + "]";
	}
}
