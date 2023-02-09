package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.PersonDto;
import com.example.demo.dto.ProjectDto;
import com.example.demo.dto.TaskDto;
import com.example.demo.model.Person;
import com.example.demo.model.Project;
import com.example.demo.model.Task;

@Mapper(componentModel = "spring")
public interface MapstructMapper {
	Person personDtoToPerson(PersonDto personDto);
	Project projectDtoToProject(ProjectDto projectDto);
	Task taskDtoTotask(TaskDto taskDto);
	PersonDto personToPersonDto(Person person);
	ProjectDto projectToProjectDto(Project project);
	TaskDto taskToTaskDto(Task task);
}
