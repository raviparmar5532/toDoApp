package com.example.demo.mapper;

import com.example.demo.dto.PersonDto;
import com.example.demo.dto.ProjectDto;
import com.example.demo.dto.TaskDto;
import com.example.demo.model.Person;
import com.example.demo.model.Project;
import com.example.demo.model.Task;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-01T12:32:27+0530",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230213-1046, environment: Java 17.0.6 (Eclipse Adoptium)"
)
*/
@Component
public class MapstructMapperImpl implements MapstructMapper {

    @Override
    public Person personDtoToPerson(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setPersonId( personDto.getPersonId() );
        person.setPersonName( personDto.getPersonName() );

        return person;
    }

    @Override
    public Project projectDtoToProject(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setProjectId( projectDto.getProjectId() );
        project.setProjectName( projectDto.getProjectName() );

        return project;
    }

    @Override
    public Task taskDtoTotask(TaskDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setTaskId( taskDto.getTaskId() );
        task.setPerson( personDtoToPerson( taskDto.getPerson() ) );
        task.setTaskName( taskDto.getTaskName() );

        return task;
    }

    @Override
    public PersonDto personToPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setPersonId( person.getPersonId() );
        personDto.setPersonName( person.getPersonName() );

        return personDto;
    }

    @Override
    public ProjectDto projectToProjectDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setProjectId( project.getProjectId() );
        projectDto.setProjectName( project.getProjectName() );

        return projectDto;
    }

    @Override
    public TaskDto taskToTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setTaskId( task.getTaskId() );
        taskDto.setPerson( personToPersonDto( task.getPerson() ) );
        taskDto.setTaskName( task.getTaskName() );

        return taskDto;
    }
}
