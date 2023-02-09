package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TaskDto;
import com.example.demo.service.serviceimpl.TaskServiceImpl;

@RestController
public class TaskController {
	@Autowired
	private TaskServiceImpl taskService;
	@GetMapping(value = "tasks")
	public List<TaskDto> getAllTask() {
		return taskService.getAllTask();
	}
	@GetMapping(value = "tasks/{id}")
	public String getTaskById(@PathVariable("id") Integer id) {
		return taskService.gettaskById(id);
	}
	@DeleteMapping(value = "tasks/{id}") 
	public String deleteById(@PathVariable("id") Integer id) {
		return taskService.deleteById(id);
	}
}
