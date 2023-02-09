package com.example.demo.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TaskDAO;
import com.example.demo.dto.TaskDto;
import com.example.demo.mapper.MapstructMapper;
import com.example.demo.service.TaskService;


@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskDAO taskDao;
	@Autowired
	private MapstructMapper mp;
	
//	Retrieve all task list
	public List<TaskDto> getAllTask() {
		return taskDao.findAll().stream().map(t -> mp.taskToTaskDto(t)).collect(Collectors.toList());
	}
//	Add new task
	@Transactional
	public String addTask(TaskDto t) {
		try {
			taskDao.save(mp.taskDtoTotask(t));
			return "New Task Created";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
//	task detail by task id
	public Object gettaskById(Integer id) {
		try {
			return taskDao.getReferenceById(id);			
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
//	deleting a task by id
	@Transactional
	public String deleteById(Integer id) {
		try {
			if(taskDao.existsById(id)) {
				taskDao.deleteById(id);		
				return "Task Deleted";
			}
			else return "No Task with ID = "+id+" exists";
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
}
