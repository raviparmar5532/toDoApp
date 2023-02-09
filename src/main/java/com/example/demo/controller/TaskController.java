package com.example.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<TaskDto>> getAllTask() {
		return new ResponseEntity<>(taskService.getAllTask(), HttpStatus.OK);
	}
	@GetMapping(value = "tasks/{id}")
	public ResponseEntity<Map<String, Object>> getTaskById(@PathVariable("id") Integer id) {
		Map<String, Object>mp = new HashMap<>();
		mp.put("Response", taskService.gettaskById(id));
		return new ResponseEntity<>(mp, HttpStatus.OK);
	}
	@DeleteMapping(value = "tasks/{id}") 
	public ResponseEntity<Map<String, String>> deleteById(@PathVariable("id") Integer id) {
		Map<String, String>mp = new HashMap<>();
		mp.put("Response", taskService.deleteById(id));
		return new ResponseEntity<>(mp, HttpStatus.OK);
	}
}
