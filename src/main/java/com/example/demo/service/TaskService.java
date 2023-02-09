package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TaskDto;

public interface TaskService {
	
//	Retrieve all task list
	public List<TaskDto> getAllTask() ;
//	Add new task
	public String addTask(TaskDto t) ;
//	task detail by task id
	public Object gettaskById(Integer id) ;
	
//	deleting a task by id
	public String deleteById(Integer id) ;
	
/*
 *  	Person Methods
 */
	
//	
}
