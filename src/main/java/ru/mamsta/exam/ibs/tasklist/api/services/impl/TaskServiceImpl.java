package ru.mamsta.exam.ibs.tasklist.api.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.mamsta.exam.ibs.tasklist.api.model.Status;
import ru.mamsta.exam.ibs.tasklist.api.model.Task;
import ru.mamsta.exam.ibs.tasklist.api.model.User;
import ru.mamsta.exam.ibs.tasklist.api.services.CatalogDataService;
import ru.mamsta.exam.ibs.tasklist.api.services.DataService;
import ru.mamsta.exam.ibs.tasklist.api.services.util.IdCounter;

@Service("taskService")
public class TaskServiceImpl implements DataService<Task> {
	
	@Autowired
	private IdCounter idCounter;
	
	@Resource(name = "userService")
	private CatalogDataService<User> userService;
	
	@Resource(name = "statusService")
	private CatalogDataService<Status> statusService;
	
	private Map<Long, Task> taskMap;
	
	@PostConstruct
	private void init() {
		taskMap = new ConcurrentHashMap<>();
		
		Long id = idCounter.nextId();
		taskMap.put(id, new Task(id, 
				"Захват матрицы", 
				"Необходимо разработать план захвата матрицы", 
				userService.getDataById(2l), 
				userService.getDataById(1l), 
				statusService.getDataById(2l)));
		
		id = idCounter.nextId();
		taskMap.put(id, new Task(id, 
				"Спасение матрицы", 
				"Необходимо спасти матрицу", 
				userService.getDataById(4l), 
				userService.getDataById(5l), 
				statusService.getDataById(1l)));
		
		id = idCounter.nextId();
		taskMap.put(id, new Task(id, 
				"Купить печенек", 
				"Сгонять в магаз и купить постапокалиптических печенек с кремом", 
				userService.getDataById(6l), 
				userService.getDataById(3l), 
				statusService.getDataById(3l)));
		
		id = idCounter.nextId();
		taskMap.put(id, new Task(id, 
				"Почитать перед сном", 
				"Почитать перед сном Гарри поттера", 
				userService.getDataById(4l), 
				userService.getDataById(5l), 
				statusService.getDataById(1l)));
		
		id = idCounter.nextId();
		taskMap.put(id, new Task(id, 
				"Связать свитер", 
				"Связать свитер губернатору", 
				userService.getDataById(5l), 
				userService.getDataById(4l), 
				statusService.getDataById(1l)));
		
		System.out.println("task test data created: " + taskMap.toString());
	}

	public List<Task> getDataList() {
		System.out.println("get all tasks");
		return new ArrayList<>(taskMap.values());
	}

	public Task getDataById(Long id) {
		System.out.println("get tasks by id");
		return taskMap.get(id);
	}

	public Task addData(Task t) {
		final Long id = idCounter.nextId();
		t.setId(id);
		taskMap.put(id, t);
		System.out.println("add task: " + t.toString());
		return t;
	}

	public Task updateData(Task t) {
		System.out.println("update task: " + t.toString());
		return taskMap.replace(t.getId(), t);
	}

	public boolean deleteData(Long id) {
		final Task task = taskMap.get(id);
		return deleteData(task);
	}

	public boolean deleteData(Task t) {
		System.out.println("del task: " + t.toString());
		return taskMap.remove(t.getId(), t);
	}
}
