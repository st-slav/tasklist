package ru.mamsta.exam.ibs.tasklist.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.mamsta.exam.ibs.tasklist.api.converters.Converter;
import ru.mamsta.exam.ibs.tasklist.api.dto.TaskDto;
import ru.mamsta.exam.ibs.tasklist.api.model.Task;
import ru.mamsta.exam.ibs.tasklist.api.services.DataService;

@RestController
@RequestMapping("/api/task/")
public class TaskController {

	@Resource(name = "taskService")
	private DataService<Task> taskService;

	@Resource(name = "taskConverter")
	private Converter<TaskDto, Task> taskConverter;

	@GetMapping()
	public ResponseEntity<List<TaskDto>> getTasks() {
		List<TaskDto> tasks = taskService.getDataList().stream().map(task -> taskConverter.getDto(task))
				.collect(Collectors.toList());
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long id) {
		return new ResponseEntity<>(taskConverter.getDto(taskService.getDataById(id)), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<TaskDto> postTask(@RequestBody TaskDto taskDto) {
		return new ResponseEntity<>(taskConverter.getDto(taskService.updateData(taskConverter.getData(taskDto))),
				HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<TaskDto> putTask(@RequestBody TaskDto taskDto) {
		return new ResponseEntity<>(taskConverter.getDto(taskService.addData(taskConverter.getData(taskDto))),
				HttpStatus.OK);
	}

	@DeleteMapping()
	public ResponseEntity<Boolean> deleteTask(@RequestParam("id") Long id) {
		return new ResponseEntity<>(taskService.deleteData(id), HttpStatus.OK);
	}
}
