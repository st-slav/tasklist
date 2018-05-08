package ru.mamsta.exam.ibs.tasklist.api.converters.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ru.mamsta.exam.ibs.tasklist.api.converters.Converter;
import ru.mamsta.exam.ibs.tasklist.api.dto.TaskDto;
import ru.mamsta.exam.ibs.tasklist.api.model.Status;
import ru.mamsta.exam.ibs.tasklist.api.model.Task;
import ru.mamsta.exam.ibs.tasklist.api.model.User;
import ru.mamsta.exam.ibs.tasklist.api.services.CatalogDataService;

@Service("taskConverter")
public class TaskConverter implements Converter<TaskDto, Task> {

	@Resource(name = "statusService")
	private CatalogDataService<Status> statusService;
	
	@Resource(name = "userService")
	private CatalogDataService<User> userService;
	
	@Override
	public TaskDto getDto(Task e) {
		return new TaskDto(e.getId(),
				e.getName(),
				e.getDescription(),
				e.getCreatedUser().getId(),
				e.getAssignedUser().getId(),
				e.getStatus().getId());
	}

	@Override
	public Task getData(TaskDto t) {
		return new Task(t.getId(),
				t.getName(),
				t.getDescription(),
				userService.getDataById(t.getCreatedUser()),
				userService.getDataById(t.getAssignedUser()),
				statusService.getDataById(t.getStatus()));
	}
}
