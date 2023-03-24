package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.example.demo.model.Project;

public interface ProjectDao extends JpaRepository<Project, Integer>{
	@Procedure(value = "add_person_in_project")
	void addPerson(Integer projectId, Integer personId);
}